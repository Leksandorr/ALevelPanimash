package com.alevelhw.module2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Telephone extends Product {
    private String model;

    public Telephone(String series, String screenType, int price) {
        super(series, screenType, price);
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "series='" + getSeries() + '\'' +
                "model='" + model + '\'' +
                "screen type='" + getScreenType() + '\'' +
                "price='" + getPrice() + '\'' +
                '}';
    }
}