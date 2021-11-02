package com.alevelhw.hw3;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String invite = "Введите одну из четырёх арифметических операций: \" + \", \" - \", \" * \", \" / \" ";

    public static void main(String[] args) {
        countTickets();
        startCalculator();
    }

    private static void startCalculator() {
        System.out.println(invite);
        calculator(scanner.nextLine());
    }

    private static void calculator(String value) {

        while (!value.equals("0")) {
            switch (value) {
                case "+":
                    System.out.println("Введите числа, которые хотите сложить ");
                    double numberFirst = getNumber();
                    double numberSecond = getNumber();
                    System.out.println(numberFirst + " + " + numberSecond + " = " + (numberFirst + numberSecond));
                    break;
                case "-":
                    System.out.println("Введите два числа. Из первого будет вычтено второе ");
                    numberFirst = getNumber();
                    numberSecond = getNumber();
                    System.out.println(numberFirst + " - " + numberSecond + " = " + (numberFirst - numberSecond));
                    break;
                case "*":
                    System.out.println("Введите числа, которые хотите умножить ");
                    numberFirst = getNumber();
                    numberSecond = getNumber();
                    System.out.println(numberFirst + " * " + numberSecond + " = " + (numberFirst * numberSecond));
                    break;
                case "/":
                    System.out.println("Введите два числа. Первое будет разделено на второе ");
                    numberFirst = getNumber();
                    numberSecond = getNumber();
                    while (numberSecond == 0) {
                        System.out.println("На ноль не буду делить. Введите другие числа");
                        numberFirst = getNumber();
                        numberSecond = getNumber();
                    }
                    System.out.println(numberFirst + " / " + numberSecond + " = " + (numberFirst / numberSecond));
                    break;
                default:
                    System.out.println(invite);
                    value = scanner.nextLine();
            }
        }
        System.out.println("Работа программы завершена");
    }

    private static double getNumber() {
        while (!scanner.hasNextDouble()) {
            String value = scanner.nextLine();
            if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) {
                calculator(value);
            }
        }
        return scanner.nextDouble();
    }

    private static void countTickets() {
        int count = 0;
        for (int i = 1001; i <= 999999; i++) {
            int[] number = makeIntArray(i);
            if (number[0] + number[1] + number[2] == number[3] + number[4] + number[5]) {
                count++;
            }
        }
        System.out.println("В одном рулоне " + count + " счастливый билет.");
    }

    private static int[] makeIntArray(int i) {
        StringBuilder builder = new StringBuilder();
        builder.append(i);
        builder.reverse();

        int length = builder.length();
        for (int j = 0; j < (6 - length); j++) {
            builder.append(0);
        }

        builder.reverse();

        char[] numberChar = builder.toString().toCharArray();
        int[] numberInt = new int[6];
        for (int j = 0; j < 6; j++) {
            numberInt[j] = Character.getNumericValue(numberChar[j]);
        }
        return numberInt;
    }
}