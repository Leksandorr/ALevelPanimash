package com.alevelhw.module2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Television {
    private String series, screenType, country;
    private int diagonal;
    private int price;
}