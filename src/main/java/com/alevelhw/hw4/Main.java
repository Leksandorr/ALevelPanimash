package com.alevelhw.hw4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    private static void task1() {
        System.out.println();
        System.out.println("Task1");
        int[] numbers = new int[8];
        int min = 1;
        int max = 10;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(max - min + 1) + min;
        }
        System.out.println(Arrays.toString(numbers));

        for (int i = 1; i < numbers.length; i += 2) {
            numbers[i] = 0;
        }
        System.out.println(Arrays.toString(numbers));
    }

    private static void task2() {
        System.out.println();
        System.out.println("Task2");
        int[] numbers = new int[4];
        int min = 10;
        int max = 99;
        boolean isAscending = false;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(max - min + 1) + min;
        }
        System.out.println(Arrays.toString(numbers));

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] < numbers[i + 1]) {
                isAscending = true;
            } else {
                isAscending = false;
                break;
            }
        }

        if (isAscending) {
            System.out.println("Массив содержит строго возрастающую последовательность");
        } else {
            System.out.println("Массив содержит не строго возрастающую последовательность");
        }
    }

    private static void task3() {
        System.out.println();
        System.out.println("Task3");
        int[] numbersOne = new int[5];
        int[] numbersTwo = new int[5];
        int min = 0;
        int max = 5;
        int sumNumbersOne = 0;
        int sumNumbersTwo = 0;

        for (int i = 0; i < numbersOne.length; i++) {
            numbersOne[i] = random.nextInt(max - min + 1) + min;
        }

        for (int i = 0; i < numbersTwo.length; i++) {
            numbersTwo[i] = random.nextInt(max - min + 1) + min;
        }
        System.out.println(Arrays.toString(numbersOne));
        System.out.println(Arrays.toString(numbersTwo));

        for (int n : numbersOne) {
            sumNumbersOne += n;
        }

        for (int n : numbersTwo) {
            sumNumbersTwo += n;
        }
        double averageOne = (double) sumNumbersOne / numbersOne.length;
        double averageTwo = (double) sumNumbersTwo / numbersTwo.length;

        if (averageOne > averageTwo) {
            System.out.println("Среднее арифметическое первого массива больше");
        } else if (averageOne < averageTwo) {
            System.out.println("Среднее арифметическое второго массива больше");
        } else {
            System.out.println("Средние арифметические массивов равны");
        }
    }

    private static void task4() {
        System.out.println();
        System.out.println("Task4");
        System.out.println("Введите натуральное число больше 3");
        Scanner scanner = new Scanner(System.in);
        int min = 0;
        int input = 0;
        int sizeEvenNumbers = 0;
        String s = scanner.next();
        boolean isFit = true;

        do {
            if (isNumber(s)) {
                input = Integer.parseInt(s);
                if (input < 4) {
                    System.out.println("Введите натуральное число больше 3");
                    s = scanner.next();
                } else {
                    isFit = false;
                }
            } else {
                System.out.println("Введите натуральное число больше 3");
                s = scanner.next();
            }
        } while (isFit);

        int[] numbers = new int[input];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(input - min + 1) + min;
        }
        System.out.println("Певрый массив");
        System.out.println(Arrays.toString(numbers));

        for (int number : numbers) {
            if (number % 2 == 0) {
                sizeEvenNumbers++;
            }
        }

        if (sizeEvenNumbers > 0) {
            int[] evenNumbers = new int[sizeEvenNumbers];
            int counter = 0;
            for (int number : numbers) {
                if (number % 2 == 0) {
                    evenNumbers[counter] = number;
                    counter++;
                }
            }
            System.out.println("Массив из чётных чисел первого массива");
            System.out.println(Arrays.toString(evenNumbers));
        } else
            System.out.println("Чётных чисел в массиве нет");
    }

    private static boolean isNumber(String s) {
        boolean isNumber = false;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                isNumber = true;
            } else {
                isNumber = false;
                break;
            }
        }
        return isNumber;
    }
}
