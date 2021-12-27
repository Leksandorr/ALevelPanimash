package com.alevelhw.module2;

import com.alevelhw.module2.model.Invoice;
import com.alevelhw.module2.service.AnalyticsService;
import com.alevelhw.module2.service.ShopService;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ShopService shopService = new ShopService();
        shopService.startShopService("D:\\", 15);
        Map<String, Invoice> invoiceMap = shopService.getInvoiceMap();
        invoiceMap.forEach((x, y) -> System.out.printf("%s=%s\n", x, y));

        AnalyticsService.printNumbersSoldTelephones(invoiceMap);
        AnalyticsService.printNumbersSoldTelevisions(invoiceMap);
        AnalyticsService.printLeastInvoice(invoiceMap, shopService);
        AnalyticsService.printSumOfOllPurchases(invoiceMap, shopService);
        AnalyticsService.printQuantityRetails(invoiceMap);
        AnalyticsService.printInvoicesWithOneTypeProducts(invoiceMap);
        AnalyticsService.printFirstThreeInvoices(invoiceMap);
        AnalyticsService.printLowAgeInvoices(invoiceMap);
        AnalyticsService.printThriceSortedInvoices(invoiceMap, shopService);
    }
}