package com.alevelhw.module1.service;

import com.alevelhw.module1.actions.ArrayActions;
import com.alevelhw.module1.actions.Lock;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class UserInputService {
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);

    public int[] getArray() {
        System.out.println("Введите число больше 9");
        int[] array = new int[scanner.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(200) - 100;
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    public void getWayOfSort(int[] array) {
        System.out.println("Введите 1 для сортировки по возростанию");
        System.out.println("Введите 2 для сортировки по убыванию");
        System.out.println("Введите 3 чтобы возвести в куб каждый третий элемент массива");
        System.out.println("Введите 4 чтобы попытаться изменить массив переданный в класс Lock");
        int input;
        do {
            input = scanner.nextInt();
            switch (input) {
                case 1: {
                    ArrayActions.sortAscending(array);
                    System.out.println(Arrays.toString(array));
                    break;
                }
                case 2: {
                    ArrayActions.sortDescending(array);
                    System.out.println(Arrays.toString(array));
                    break;
                }
                case 3: {
                    ArrayActions.toCubeThirdElement(array);
                    System.out.println(Arrays.toString(array));
                    break;
                }
                case 4: {
                    Lock lock = new Lock(array);
                    System.out.println("Массив возвращаемый классом Lock " + Arrays.toString(lock.getArray()));
                    lock.getArray()[0] = 10;
                    System.out.println("Массив возвращаемый классом Lock после попытки поменять значение" +
                            " нулевого инекса " + Arrays.toString(lock.getArray()));
                    int[] demo = new int[array.length];
                    System.arraycopy(demo, 0, lock.getArray(), 0, lock.getArray().length);
                    System.out.println("Массив возвращаемый классом Lock после попытки скопировать в него" +
                            " массив с нулевыми значениями " + Arrays.toString(lock.getArray()));
                    break;
                }
            }
        } while (true);
    }
}