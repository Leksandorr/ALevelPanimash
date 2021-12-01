package com.alevelhw.hw12;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        try {
            throw new Exception("В блоке try");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("В блоке finally");
        }

        try {
            WithTwoExceptions.f();
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        try {
            WithThreeExceptions.doAction(200);
        } catch (IllegalArgumentException | InputMismatchException | ArrayIndexOutOfBoundsException exception) {
            exception.printStackTrace();
        }
    }
}
