package com.alevelhw.hw12;

public class WithTwoExceptions {

    public static void f() {
        try {
            System.out.println(18 / g(0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new ArithmeticException("Ноль не прошёл!");
        }
    }

    public static int g(int number) {
        if (number == 0) {
            throw new IllegalArgumentException("Ноль не пройдёт!");
        }
        return number;
    }
}
