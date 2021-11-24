package com.alevelhw.hw3.service;

import com.alevelhw.hw3.action.Divide;
import com.alevelhw.hw3.action.Multiple;
import com.alevelhw.hw3.action.Subtract;
import com.alevelhw.hw3.action.Sum;
import com.alevelhw.hw3.model.Numbers;

import java.util.Scanner;

public class UserActionServiceVar1 {
    private static final Scanner scanner = new Scanner(System.in);
    Numbers numbers;
    Sum sum = new Sum();
    Subtract subtract = new Subtract();
    Multiple multiple = new Multiple();
    Divide divide = new Divide();

    public void calculator() {
        do {
            System.out.println("Введите одну из четырёх арифметических операций:" +
                    " \" + \", \" - \", \" * \", \" / \"\nДля выхода из программы введите 0. ");
            switch (scanner.next()) {
                case "+": {
                    System.out.print("Введите два числа. Из первого будет вычтено второе\n");
                    numbers.setNumberFirst(scanner.next());
                    numbers.setNumberSecond(scanner.next());
                    System.out.printf("%f + %f = %f\n",
                            numbers.getNumberFirst(),
                            numbers.getNumberSecond(),
                            sum.doAction(numbers.getNumberFirst(), numbers.getNumberSecond()));
                    break;
                }
                case "-": {
                    System.out.print("Введите два числа. Из первого будет вычтено второе\n");
                    numbers.setNumberFirst(scanner.next());
                    numbers.setNumberSecond(scanner.next());
                    System.out.printf("%f - %f = %f\n",
                            numbers.getNumberFirst(),
                            numbers.getNumberSecond(),
                            subtract.doAction(numbers.getNumberFirst(), numbers.getNumberSecond()));
                    break;
                }
                case "*": {
                    System.out.print("Введите числа, которые хотите умножить\n");
                    numbers.setNumberFirst(scanner.next());
                    numbers.setNumberSecond(scanner.next());
                    System.out.printf("%f * %f = %f\n",
                            numbers.getNumberFirst(),
                            numbers.getNumberSecond(),
                            multiple.doAction(numbers.getNumberFirst(), numbers.getNumberSecond()));
                    break;
                }
                case "/": {
                    System.out.print("Введите два числа. Первое будет разделено на второе\n");
                    numbers.setNumberFirst(scanner.next());
                    numbers.setNumberSecond(scanner.next());
                    while (numbers.getNumberSecond() == 0) {
                        System.out.print("На ноль не буду делить. Введите другие числа\n");
                        numbers.setNumberFirst(scanner.next());
                        numbers.setNumberSecond(scanner.next());
                    }
                    System.out.printf("%f - %f = %f\n",
                            numbers.getNumberFirst(),
                            numbers.getNumberSecond(),
                            divide.doAction(numbers.getNumberFirst(), numbers.getNumberSecond()));
                    break;
                }
                case "0": {
                    System.out.println("Работа программы завершена");
                    System.exit(0);
                }
            }
        } while (true);
    }
}