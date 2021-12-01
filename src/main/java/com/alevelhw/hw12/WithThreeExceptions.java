package com.alevelhw.hw12;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WithThreeExceptions {
    static Scanner scanner = new Scanner(System.in);
    static int [] arr = new int[3];

    public static void doAction(int number) throws IllegalArgumentException, InputMismatchException, ArrayIndexOutOfBoundsException {
        System.out.println("Введите число. Или не число.");
        int result;
        if (!scanner.hasNextInt()) {
            throw new InputMismatchException("Введено не целое число");
        }
        else if (number == 200){
            throw new IllegalArgumentException("Недопустимый аргумент метода");
        }
        else {
            result = scanner.nextInt() / (number - 200);
        }

        if (result < 0 || result >= arr.length ) {
            throw new ArrayIndexOutOfBoundsException("Выход за пределы массива");
        }
        else {
            arr[result] = result;
            System.out.println(Arrays.toString(arr));
        }
    }
}
