package com.alevelhw.hw3.model;

public class Numbers {
    private double numberFirst;
    private double numberSecond;

    public Numbers(String numberFirst, String numberSecond) {
        this.numberFirst = Double.parseDouble(numberFirst);
        this.numberSecond = Double.parseDouble(numberSecond);
    }

    public double getNumberFirst() {
        return numberFirst;
    }

    public void setNumberFirst(String numberFirst) {
        this.numberFirst = Double.parseDouble(numberFirst);
    }

    public double getNumberSecond() {
        return numberSecond;
    }

    public void setNumberSecond(String numberSecond) {
        this.numberSecond = Double.parseDouble(numberSecond);
    }
}
