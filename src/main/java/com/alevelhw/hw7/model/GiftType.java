package com.alevelhw.hw7.model;

public enum GiftType {
    GIFT100(100, 20),
    GIFT150(150, 25),
    GIFT200(200, 30);

    private final int price;
    private final int addHappy;

    GiftType(int price, int addHappy) {
        this.price = price;
        this.addHappy = addHappy;
    }

    public int getPrice() {
        return price;
    }

    public int getAddHappy() {
        return addHappy;
    }
}
