package com.alevelhw.module2;

import com.alevelhw.module2.model.Invoice;
import com.alevelhw.module2.service.AnalyticsService;
import com.alevelhw.module2.service.ShopService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ShopService shopService = new ShopService();
        shopService.startShopService("D:\\invoices.log", 15);
        Map<LocalDateTime, Invoice> invoiceMap = shopService.getInvoiceMap();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss:SSS");
        invoiceMap.forEach((x, y) -> System.out.printf("[%s]=[%s]\n", x.format(formatter), y));

        AnalyticsService.printNumbersSoldTelephones(invoiceMap);
        AnalyticsService.printNumbersSoldTelevisions(invoiceMap);
        AnalyticsService.printLeastInvoice(invoiceMap, shopService);
        AnalyticsService.printSumOfOllPurchases(invoiceMap, shopService);
        AnalyticsService.printQuantityRetails(invoiceMap);
        AnalyticsService.printInvoicesWithOneTypeProducts(invoiceMap);
        AnalyticsService.printFirstThreeInvoices(invoiceMap);
        AnalyticsService.printLowAgeInvoices(invoiceMap);
        AnalyticsService.printAgeThenQuantityProductsThenPriceSorting(invoiceMap, shopService);
    }
}