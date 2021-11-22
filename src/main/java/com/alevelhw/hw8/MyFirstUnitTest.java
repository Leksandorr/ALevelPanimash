package com.alevelhw.hw8;

public class MyFirstUnitTest {
    public static void countSumDigitsOfNumber (String sNumber) {
        char[] charNumber = sNumber.toCharArray();
        for (int i = 0; i < charNumber.length; i++) {
            if (Character.isDigit(charNumber[i]) || sNumber.toCharArray()[0] == '-') {
                int number = Integer.parseInt(sNumber);
                if (number < 0) {
                    System.out.print("Введите положительное число\n");
                }else {
                    int sum = 0;
                    for (int j = 0; j < sNumber.length(); j++) {
                        final int part = number % 10;
                        sum = sum + part;
                        number = number / 10;
                    }
                    System.out.print(sum);
                }
                break;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}
