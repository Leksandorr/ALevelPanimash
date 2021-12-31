package com.alevelhw.module2.model;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
public class Invoice {
    private Customer customer;
    private String type;
    private Set <Product> productSet = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "Invoice{" +
                "customer=" + customer +
                ", type='" + type + '\'' +
                ", productSet=" + productSet.toString() +
                '}';
    }
}