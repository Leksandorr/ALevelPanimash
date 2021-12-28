package com.alevelhw.module2.service;

import com.alevelhw.module2.model.Invoice;
import com.alevelhw.module2.model.Telephone;
import com.alevelhw.module2.model.Television;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

public class AnalyticsService {
    public static void printNumbersSoldTelephones(Map<LocalDateTime, Invoice> invoiceMap) {
        Collection<Invoice> invoiceSet = invoiceMap.values();
        int numbersSoldTelephones = (int) invoiceSet.stream()
                .flatMap(x -> x.getProductSet().stream())
                .filter(x -> x instanceof Telephone)
                .count();
        System.out.println("Количество проданных телефонов: " + numbersSoldTelephones);
    }

    public static void printNumbersSoldTelevisions(Map<LocalDateTime, Invoice> invoiceMap) {
        Collection<Invoice> invoiceSet = invoiceMap.values();
        int numbersSoldTelevisions = (int) invoiceSet.stream()
                .flatMap(x -> x.getProductSet().stream())
                .filter(x -> x instanceof Television)
                .count();
        System.out.println("Количество проданных телевизоров: " + numbersSoldTelevisions);
    }

    public static void printLeastInvoice(Map<LocalDateTime, Invoice> invoiceMap, ShopService shopService) {
        Collection<Invoice> invoiceSet = invoiceMap.values();
        Comparator<Invoice> comparator = Comparator.comparingInt(shopService::getTotalPriceInvoice);
        Invoice leastInvoice = invoiceSet.stream()
                .min(comparator)
                .orElse(new Invoice());
        System.out.printf("Сумма наименьшего чека у покупателя: %s и составляет: %s\n",
                leastInvoice.getCustomer(), shopService.getTotalPriceInvoice(leastInvoice));
    }

    public static void printSumOfOllPurchases(Map<LocalDateTime, Invoice> invoiceMap, ShopService shopService) {
        Collection<Invoice> invoiceSet = invoiceMap.values();
        int sumOllPurchase = invoiceSet.stream()
                .map(shopService::getTotalPriceInvoice)
                .mapToInt(x -> x)
                .sum();
        System.out.println("Сумма всех покупок: " + sumOllPurchase);
    }

    public static void printQuantityRetails(Map<LocalDateTime, Invoice> invoiceMap) {
        Collection<Invoice> invoiceSet = invoiceMap.values();
        int quantityRetail = (int) invoiceSet.stream()
                .filter(x -> x.getType().equals("retail"))
                .count();
        System.out.println("Количество инвойсов категории retail: " + quantityRetail);
    }

    public static void printInvoicesWithOneTypeProducts(Map<LocalDateTime, Invoice> invoiceMap) {
        Collection<Invoice> invoiceSet = invoiceMap.values();
        int invoicesWithOneTypeProducts = (int) invoiceSet.stream()
                .filter(x -> {
                    int numbersOfTelephones = (int) x.getProductSet()
                            .stream()
                            .filter(z -> z instanceof Telephone)
                            .count();
                    int numbersOfTelevisions = (int) x.getProductSet()
                            .stream()
                            .filter(z -> z instanceof Television)
                            .count();
                    return numbersOfTelephones == 0 || numbersOfTelevisions == 0;
                })
                .count();
        System.out.println("Количество инвойсов которые содержат только один тип товара: "
                + invoicesWithOneTypeProducts);
    }

    public static void printFirstThreeInvoices(Map<LocalDateTime, Invoice> invoiceMap) {
        Set<Map.Entry<LocalDateTime, Invoice>> invoiceSet = invoiceMap.entrySet();
        System.out.println("Первые три инвойса:");
        invoiceSet.stream()
                .limit(3)
                .forEach(System.out::println);
    }

    public static void printLowAgeInvoices(Map<LocalDateTime, Invoice> invoiceMap) {
        Collection<Invoice> invoiceSet = invoiceMap.values();
        System.out.println("Инвойсы покупателей младше 18 лет:");
        invoiceSet.stream()
                .filter(x -> x.getCustomer().getAge() < 18)
                .peek(x -> x.setType("low_age"))
                .forEach(System.out::println);
    }

    public static void printAgeThenQuantityProductsThenPriceSorting(Map<LocalDateTime, Invoice> invoiceMap,
                                                                    ShopService shopService) {
        Collection<Invoice> invoiceSet = invoiceMap.values();
        Comparator<Invoice> ageComparator = Comparator.comparingInt(x -> x.getCustomer().getAge());
        Comparator<Invoice> quantityProductsComparator = Comparator.comparingInt(x -> x.getProductSet().size());
        Comparator<Invoice> totalPriceComparator = Comparator.comparingInt(shopService::getTotalPriceInvoice);

        Comparator<Invoice> ageThenQuantityProductsThenPriceComparator = ageComparator.reversed()
                .thenComparing(quantityProductsComparator.thenComparing(totalPriceComparator));
        System.out.println("Инвойсы отсортированные сначала по возрасту покупателя от большего к меньшему," +
                " далее по количеству купленных предметов, далее по общей сумме купленных предметов:");
        invoiceSet.stream()
                .sorted(ageThenQuantityProductsThenPriceComparator)
                .forEach(System.out::println);
    }
}
