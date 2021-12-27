package com.alevelhw.module2.service;

import com.alevelhw.module2.model.Invoice;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

public class AnalyticsService {
    public static void printNumbersSoldTelephones(Map<String, Invoice> invoiceMap) {
        Set<Map.Entry<String, Invoice>> invoiceSet = invoiceMap.entrySet();
        int numbersSoldTelephones = (int) invoiceSet.stream()
                .map(x -> x.getValue()
                        .getTelephonesSet()
                        .size())
                .mapToInt(x -> x)
                .summaryStatistics()
                .getSum();
        System.out.println("Количество проданных телефонов: " + numbersSoldTelephones);
    }

    public static void printNumbersSoldTelevisions(Map<String, Invoice> invoiceMap) {
        Set<Map.Entry<String, Invoice>> invoiceSet = invoiceMap.entrySet();
        int numbersSoldTelevisions = (int) invoiceSet.stream()
                .map(x -> x.getValue()
                        .getTelevisionsSet()
                        .size())
                .mapToInt(x -> x)
                .summaryStatistics()
                .getSum();
        System.out.println("Количество проданных телевизоров: " + numbersSoldTelevisions);
    }

    public static void printLeastInvoice(Map<String, Invoice> invoiceMap, ShopService shopService) {
        Set<Map.Entry<String, Invoice>> invoiceSet = invoiceMap.entrySet();
        Comparator<Invoice> comparator = Comparator.comparingInt(shopService::getTotalPriceInvoice);
        Invoice leastInvoice = invoiceSet.stream()
                .map(Map.Entry::getValue)
                .min(comparator)
                .orElse(new Invoice());
        System.out.printf("Сумма наименьшего чека у покупателя: %s и составляет: %s\n",
                leastInvoice.getCustomer(), shopService.getTotalPriceInvoice(leastInvoice));
    }

    public static void printSumOfOllPurchases(Map<String, Invoice> invoiceMap, ShopService shopService) {
        Set<Map.Entry<String, Invoice>> invoiceSet = invoiceMap.entrySet();
        int sumOllPurchase = invoiceSet.stream()
                .map(Map.Entry::getValue)
                .map(shopService::getTotalPriceInvoice)
                .mapToInt(x -> x)
                .sum();
        System.out.println("Сумма всех покупок: " + sumOllPurchase);
    }

    public static void printQuantityRetails(Map<String, Invoice> invoiceMap) {
        Set<Map.Entry<String, Invoice>> invoiceSet = invoiceMap.entrySet();
        int quantityRetail = (int) invoiceSet.stream()
                .map(Map.Entry::getValue)
                .filter(x -> x.getType().equals("retail"))
                .count();
        System.out.println("Количество инвойсов категории retail: " + quantityRetail);
    }

    public static void printInvoicesWithOneTypeProducts(Map<String, Invoice> invoiceMap) {
        Set<Map.Entry<String, Invoice>> invoiceSet = invoiceMap.entrySet();
        int invoicesWithOneTypeProducts = (int) invoiceSet.stream()
                .map(Map.Entry::getValue)
                .filter(x -> x.getTelephonesSet().size() == 0 || x.getTelevisionsSet().size() == 0)
                .count();
        System.out.println("Количество инвойсов которые содержат только один тип товара: "
                + invoicesWithOneTypeProducts);
    }

    public static void printFirstThreeInvoices(Map<String, Invoice> invoiceMap) {
        Set<Map.Entry<String, Invoice>> invoiceSet = invoiceMap.entrySet();
        System.out.println("Первые три инвойса:");
        invoiceSet.stream()
                .limit(3)
                .forEach(System.out::println);
    }

    public static void printLowAgeInvoices(Map<String, Invoice> invoiceMap) {
        Set<Map.Entry<String, Invoice>> invoiceSet = invoiceMap.entrySet();
        System.out.println("Инвойсы покупателей младше 18 лет:");
        invoiceSet.stream()
                .map(Map.Entry::getValue)
                .filter(x -> x.getCustomer().getAge() < 18)
                .peek(x -> x.setType("low_age"))
                .forEach(System.out::println);
    }

    public static void printThriceSortedInvoices(Map<String, Invoice> invoiceMap, ShopService shopService) {
        Set<Map.Entry<String, Invoice>> invoiceSet = invoiceMap.entrySet();
        Comparator<Map.Entry<String, Invoice>> comparator =
                Comparator.comparingInt(x -> x.getValue().getCustomer().getAge());
        System.out.println("Инвойсы отсортированные по возрасту покупателя от большего к меньшему:");
        invoiceSet.stream()
                .sorted(comparator.reversed())
                .forEach(System.out::println);

        comparator = Comparator.comparingInt(x
                -> x.getValue().getTelephonesSet().size()
                + x.getValue().getTelevisionsSet().size());
        System.out.println("Инвойсы отсортированные по количеству купленных товаров:");
        invoiceSet.stream()
                .sorted(comparator)
                .forEach(System.out::println);

        comparator = Comparator.comparingInt(x
                -> shopService.getTotalPriceInvoice(x.getValue()));
        System.out.println("Инвойсы отсортированные по общей стоимости купленных товаров:");
        invoiceSet.stream()
                .sorted(comparator)
                .forEach(System.out::println);
    }
}
