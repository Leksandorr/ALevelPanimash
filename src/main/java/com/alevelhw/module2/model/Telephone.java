package com.alevelhw.module2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Telephone {
    private String series, model, screenType;
    private int price;
}