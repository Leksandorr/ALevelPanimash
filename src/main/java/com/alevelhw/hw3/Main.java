package com.alevelhw.hw3;

import com.alevelhw.hw3.service.UserActionService;

public class Main {

    public static void main(String[] args) {
        //countTickets();
        UserActionService calculator = new UserActionService();
        calculator.calculator();
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