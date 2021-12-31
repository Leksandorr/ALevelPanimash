package com.alevelhw.module2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class Product {
    private String series, screenType;
    private int price;
}
