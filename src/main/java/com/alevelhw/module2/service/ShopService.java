package com.alevelhw.module2.service;

import com.alevelhw.module2.exception.IncorrectReadStringException;
import com.alevelhw.module2.model.Invoice;
import com.alevelhw.module2.model.Telephone;
import com.alevelhw.module2.model.Television;
import com.alevelhw.module2.util.Util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class ShopService {
    private final Map<String, Invoice> invoiceMap = new LinkedHashMap<>();
    private final List<String> productsList = new ArrayList<>();
    private final PersonService personService = new PersonService();
    private int limitRetail;

    public Map<String, Invoice> getInvoiceMap() {
        return invoiceMap;
    }

    public void startShopService(String targetDirectory, int numberOfPurchase) {
        limitRetail = Util.getRandomInt(2500, 3000);
        fillListOfProductsFromFile();
        for (int i = 0; i < numberOfPurchase; i++) {
            Invoice invoice = getRandomInvoice();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss:SSS");
            String dateTime = LocalDateTime.now().format(formatter);
            invoiceMap.put(dateTime, invoice);
            writeInvoiceToLogFile(invoice, targetDirectory, dateTime);
        }
    }

    private void fillListOfProductsFromFile() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("csv/goods.csv");
        String line;
        if (inputStream != null) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                bufferedReader.readLine();
                while ((line = bufferedReader.readLine()) != null) {
                    productsList.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Invoice getRandomInvoice() {
        Invoice invoice = new Invoice();
        int minQuantityProductsInInvoice = 1;
        int maxQuantityProductsInInvoice = 5;
        int quantityProductsInInvoice = Util.getRandomInt(minQuantityProductsInInvoice, maxQuantityProductsInInvoice);
        for (int i = 0; i < quantityProductsInInvoice; i++) {
            int randomProduct = Util.getRandomInt(0, productsList.size() - 1);
            String[] product = productsList.get(randomProduct).split(",");
            if (product[0].equals("Telephone")) {
                try {
                    invoice.getTelephonesSet().add(getTelephone(product));
                } catch (IncorrectReadStringException e) {
                    System.out.println("Ошибка. Товар не добавлен в инвойс: " + e);
                }
            } else if (product[0].equals("Television")) {
                try {
                    invoice.getTelevisionsSet().add(getTelevision(product));
                } catch (IncorrectReadStringException e) {
                    System.out.println("Ошибка. Товар не добавлен в инвойс: " + e);
                }
            } else {
                throw new IllegalStateException("Unknown product");
            }
        }
        invoice.setCustomer(personService.getNewCustomer());
        if (getTotalPriceInvoice(invoice) <= limitRetail) {
            invoice.setType("retail");
        }
        else {
            invoice.setType("wholesale");
        }
        return invoice;
    }

    public int getTotalPriceInvoice(Invoice invoice) {
        int totalPriceTelephone = (int) invoice.getTelephonesSet()
                .stream()
                .map(Telephone::getPrice)
                .mapToInt(i -> i)
                .summaryStatistics().getSum();
        int totalPriceTelevision = (int) invoice.getTelevisionsSet()
                .stream()
                .map(Television::getPrice)
                .mapToInt(i -> i)
                .summaryStatistics().getSum();
        return totalPriceTelephone + totalPriceTelevision;
    }

    private Telephone getTelephone(String[] product) throws IncorrectReadStringException {
        Telephone telephone = new Telephone();
        String series = product[1];
        String model = product[2];
        String screenType = product[4];
        String price = product[6];
        if (series.equals("") || series.equals(" ")
                || model.equals("") || model.equals(" ")
                || screenType.equals("") || screenType.equals(" ")
                || price.equals("") || price.equals(" ")) {
            throw new IncorrectReadStringException(series);
        } else {
            telephone.setSeries(series);
            telephone.setModel(model);
            telephone.setScreenType(screenType);
            telephone.setPrice(Integer.parseInt(price));
        }
        return telephone;
    }

    private Television getTelevision(String[] product) throws IncorrectReadStringException {
        Television television = new Television();
        String series = product[1];
        String diagonal = product[3];
        String screenType = product[4];
        String country = product[5];
        String price = product[6];
        if (series.equals("") || series.equals(" ")
                || diagonal.equals("") || diagonal.equals(" ")
                || screenType.equals("") || screenType.equals(" ")
                || country.equals("") || country.equals(" ")
                || price.equals("") || price.equals(" ")) {
            throw new IncorrectReadStringException(series);
        } else {
            television.setSeries(series);
            television.setDiagonal(Integer.parseInt(diagonal));
            television.setScreenType(screenType);
            television.setCountry(country);
            television.setPrice(Integer.parseInt(price));
        }
        return television;
    }

    private void writeInvoiceToLogFile(Invoice invoice, String targetDirectory, String dateTime) {
        String logFlePath = targetDirectory +
                "Invoice " +
                " [CustomerID " +
                invoice.getCustomer().getId() +
                "]" +
                ".log";
        try (PrintWriter writer = new PrintWriter((logFlePath), StandardCharsets.UTF_8)) {
            writer.printf("[%s]", dateTime);
            writer.printf("[%s]", invoice.getCustomer());
            if (invoice.getTelephonesSet().size() != 0) {
                invoice.getTelephonesSet()
                        .forEach(x -> writer.printf("[%s]", x));
            }
            if (invoice.getTelevisionsSet().size() != 0) {
                invoice.getTelevisionsSet()
                        .forEach(x -> writer.printf("[%s]", x));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
