package com.alevelhw.module2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Television extends Product {
    private String country;
    private int diagonal;

    public Television(String series, String screenType, int price) {
        super(series, screenType, price);
    }

    @Override
    public String toString() {
        return "Television{" +
                "series='" + getSeries() + '\'' +
                "diagonal=" + diagonal + '\'' +
                "screen type='" + getScreenType() + '\'' +
                "country='" + country + '\'' +
                "price='" + getPrice() + '\'' +
                '}';
    }
}