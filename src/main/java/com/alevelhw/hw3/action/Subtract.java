package com.alevelhw.hw3.action;

public class Subtract {
    private double numberFirst;
    private double numberSecond;

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

    public double doAction() {
        return numberFirst - numberSecond;
    }
}
