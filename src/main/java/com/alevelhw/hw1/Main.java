package com.alevelhw.hw1;

public class Main {
    public static void main(String[] args) {

        String firstName = "Aleksandr";
        String lastName = "Panimash";
        int value = 5;

        System.out.println(firstName + " " + lastName);

        if (firstName.length() > 7) {
            System.out.println("more than 7");
        } else
            System.out.println("less than 7");

        System.out.println();

        for (int i = 0; i <= 10; i++) {
            System.out.println("Шаг " + i + ", значение " + value);
            value += 2;
        }
    }
}
