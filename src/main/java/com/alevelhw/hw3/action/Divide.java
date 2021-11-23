package com.alevelhw.hw3.action;

public class Divide {
    public double doAction(double numberFirst, double numberSecond) {
        if (numberSecond == 0) {
            throw  new IllegalArgumentException();
        }
        return numberFirst / numberSecond;
    }
}
