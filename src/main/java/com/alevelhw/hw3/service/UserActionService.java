package com.alevelhw.hw3.service;

import com.alevelhw.hw3.action.*;
import java.util.Scanner;

public class UserActionService {
    private static final Scanner scanner = new Scanner(System.in);
    Subtract subtract = new Subtract();
    Multiple multiple = new Multiple();
    Divide divide = new Divide();

    String numberFirst;
    String numberSecond;

    public void calculator() {
        do {
            System.out.println("Введите одну из четырёх арифметических операций:" +
                    " \" + \", \" - \", \" * \", \" / \"\nДля выхода из программы введите 0. ");
            switch (scanner.next()) {
                case "+": {
                    System.out.print("Введите числа, которые хотите сложить\n");
                    Sum sum = new Sum(scanner.next(), scanner.next());
                    System.out.println(sum);
                    break;
                }
                case "-": {
                    System.out.print("Введите два числа. Из первого будет вычтено второе\n");
                    subtract.setNumberFirst(scanner.next());
                    subtract.setNumberSecond(scanner.next());
                    System.out.printf("%f - %f = %f\n",subtract.getNumberFirst(),
                            subtract.getNumberSecond(), subtract.doAction());
                    break;
                }
                case "*": {
                    System.out.print("Введите числа, которые хотите умножить\n");
                    multiple.setNumberFirst(scanner.next());
                    multiple.setNumberSecond(scanner.next());
                    System.out.printf("%f * %f = %f\n",multiple.getNumberFirst(),
                            multiple.getNumberSecond(), multiple.doAction());
                    break;
                }
                case "/": {
                    System.out.print("Введите два числа. Первое будет разделено на второе\n");
                    numberFirst = scanner.next();
                    numberSecond = scanner.next();
                    while (numberSecond.equals("0")) {
                        System.out.print("На ноль не буду делить. Введите другие числа\n");
                        numberFirst = scanner.next();
                        numberSecond = scanner.next();
                    }
                    divide.setNumberFirst(numberFirst);
                    divide.setNumberSecond(numberSecond);
                    System.out.printf("%f / %f = %f\n",divide.getNumberFirst(),
                            divide.getNumberSecond(), divide.doAction());
                    break;
                }
                case "1": {
                    System.out.print("Тут можно посчитать трапеции\n");
                }
                case "0": {
                    System.out.println("Работа программы завершена");
                    System.exit(0);
                }
            }
        } while (true);
    }
}
