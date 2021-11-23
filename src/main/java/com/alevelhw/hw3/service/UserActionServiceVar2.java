package com.alevelhw.hw3.service;

import com.alevelhw.hw3.model.Numbers;
import com.alevelhw.hw3.model.Sign;

import java.util.Scanner;

public class UserActionServiceVar2 {
    private static final Scanner scanner = new Scanner(System.in);
    UserActionOperationService userActionOperationService = new UserActionOperationService();
    double result;
    Numbers numbers;
    Sign sign;

    public void calculator() {
        do {
            System.out.println("Введите одну из четырёх арифметических операций:" +
                    " \" + \", \" - \", \" * \", \" / \"\nДля выхода из программы введите 0. ");
            switch (scanner.next()) {
                case "+": {
                    System.out.print("Введите числа, которые хотите сложить\n");
                    sign = new Sign('+');
                    numbers.setNumberFirst(scanner.next());
                    numbers.setNumberSecond(scanner.next());
                    System.out.printf("%f + %f = %f\n",
                            numbers.getNumberFirst(),
                            numbers.getNumberSecond(),
                            userActionOperationService.doAction(sign, numbers));
                    break;
                }
                case "-": {
                    System.out.print("Введите два числа. Из первого будет вычтено второе\n");
                    sign = new Sign('-');
                    numbers.setNumberFirst(scanner.next());
                    numbers.setNumberSecond(scanner.next());
                    System.out.printf("%f - %f = %f\n",
                            numbers.getNumberFirst(),
                            numbers.getNumberSecond(),
                            userActionOperationService.doAction(sign, numbers));
                    break;
                }
                case "*": {
                    System.out.print("Введите числа, которые хотите умножить\n");
                    sign = new Sign('*');
                    numbers.setNumberFirst(scanner.next());
                    numbers.setNumberSecond(scanner.next());
                    result = userActionOperationService.doAction(sign, numbers);
                    System.out.printf("%f * %f = %f\n",
                            numbers.getNumberFirst(),
                            numbers.getNumberSecond(),
                            userActionOperationService.doAction(sign, numbers));
                    break;
                }
                case "/": {
                    System.out.print("Введите два числа. Первое будет разделено на второе\n");
                    sign = new Sign('/');
                    numbers.setNumberFirst(scanner.next());
                    numbers.setNumberSecond(scanner.next());
                    while (numbers.getNumberSecond() == 0) {
                        System.out.print("На ноль не буду делить. Введите другие числа\n");
                        numbers.setNumberFirst(scanner.next());
                        numbers.setNumberSecond(scanner.next());
                    }
                    System.out.printf("%f / %f = %f\n",
                            numbers.getNumberFirst(),
                            numbers.getNumberSecond(),
                            userActionOperationService.doAction(sign, numbers));
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