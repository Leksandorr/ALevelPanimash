package com.alevelhw.hw2;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Если вы хотите найти площадь треугольника по трём его сторонам, введите 1");
        System.out.println("Если вы хотите узнать наименьшее по модулю из трёх случайных чисел, введите 2");
        System.out.println("Если вы хотите узнать является ли случайное число чётным, введите 3");
        System.out.println("Если вы хотите перевести число из десятичной системы счиления в двоичну, введите 4");

        Scanner console = new Scanner(System.in);
        String value = console.next();
        Main main = new Main();

        if (value.equals("1")) {
            System.out.println("Введите длинну стороны А");
            double a = Double.parseDouble(console.next());
            System.out.println("Введите длинну стороны B");
            double b = Double.parseDouble(console.next());
            System.out.println("Введите длинну стороны C");
            double c = Double.parseDouble(console.next());
            if (Double.isNaN(main.calcSquareTriangle(a, b, c))) {
                System.out.println("Такого треугольника не существует.");
            }
            else
                System.out.println("Площадь треугольника равна: " + main.calcSquareTriangle(a, b, c));
        }
        else if (value.equals("2")) {
            main.equalsRandomNumbers();
        }
        else if (value.equals("3")) {
            main.isPositive();
        }
        else if (value.equals("4")) {
            System.out.println("Введите целое число");
            int number = Integer.parseInt(console.next());
            System.out.println("Двоичное представление введённого числа: " + main.toBinary(number));
        }
        else {
            System.out.println("Запустите программу и введите одно из предложенных значений");
        }
    }

    double calcSquareTriangle(double sideA, double sideB, double sideC) {
        double halfPerimeter = (sideA + sideB + sideC) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
    }

    void equalsRandomNumbers() {

        Random r = new Random();
        int a = r.nextInt();
        int b = r.nextInt();
        int c = r.nextInt();

        System.out.println("Сгенерировано три случайных числа: " + a + ", " + b + ", " + c);

        a = Math.abs(a);
        b = Math.abs(b);
        c = Math.abs(c);

        int result = (a < b) & (a < c) ? a :
                (b < c) ? b : c;

        System.out.println("Наименьшее по модулю: " + result);
    }

    void isPositive() {

        Random r = new Random();
        int n = r.nextInt();

        if (n % 2 == 0) {
            System.out.println("Сгенерировано чётное число: " + n);
        } else
            System.out.println("Сгенерировано нечётное число: " + n);
    }

    String toBinary(int number) {

        StringBuilder builder = new StringBuilder();
        int temp;

        if (number >= 0) {
            while (true) {
                int n = number % 2;
                builder.append(n);
                if (number == 0 || number == 1) {
                    break;
                }
                number /= 2;
            }

            if (!(builder.length() % 4 == 0)) {
                for (int i = 0; i < builder.length() % 4; i++) {
                    builder.append(0);
                }
            }

            builder.reverse();

            temp = builder.length();
            for (int i = 1; i <= temp / 4 - 1; i++) {
                builder.insert((i * 4) + i - 1, " ");
            }
        }
        else {
            int absNumber = Math.abs(number);
            while (true) {
                int n = absNumber % 2;
                builder.append(n);
                if (absNumber == 0 || absNumber == 1) {
                    break;
                }
                absNumber /= 2;
            }

            temp = builder.length();
            for (int i = 0; i < (32 - temp); i++) {
                builder.append(0);
            }

            builder.reverse();

            for (int i = 0; i < builder.length(); i++) {
                if (builder.charAt(i) == '0') {
                    builder.setCharAt(i, '1');
                }
                else builder.setCharAt(i, '0');
            }

            if (builder.charAt(31) == '0') {
                builder.setCharAt(31, '1');
            }
            else {
                builder.setCharAt(31, '0');
                builder.setCharAt(30, '1');
            }
            temp = builder.length();
            for (int i = 1; i <= temp / 4 - 1; i++) {
                builder.insert((i * 4) + i - 1, " ");
            }
        }
        return builder.toString();
    }
    // Another way, much better:    String toBinary(int number) {return Integer.toBinaryString(number);}
}
