package com.alevelhw.hw3.action;

public class Sum {
    private final double numberFirst;
    private final double numberSecond;

    public Sum(String numberFirst, String numberSecond) {
        this.numberFirst = Double.parseDouble(numberFirst);
        this.numberSecond = Double.parseDouble(numberSecond);
    }

    public double doAction() {
        return numberFirst + numberSecond;
    }

    @Override
    public String toString() {
        return numberFirst + " + " + numberSecond + " = " + doAction();
    }
}