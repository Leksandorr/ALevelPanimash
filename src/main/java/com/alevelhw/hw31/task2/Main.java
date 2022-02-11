package com.alevelhw.hw31.task2;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(2147483647, 397, 947, 18, 5555555, 17, 1, 25, 9239, 9227, 2147483647, 63, 99, 24, 47, 97, 41, 5888888, 15, 2, 16, 3, 2147483647, 2147483647);
        AtomicInteger countHead = new AtomicInteger();
        AtomicInteger countTail = new AtomicInteger();

        Runnable runnableHead = () -> {
            for (int i = 0; i < integerList.size() / 2; i++) {
                if (isPrimeNumber(integerList.get(i))) {
                    countHead.getAndIncrement();
                    System.out.println("В потоке Head - " + integerList.get(i));
                }
            }
        };

        Runnable runnableTail = () -> {
            for (int i = integerList.size() / 2; i < integerList.size(); i++) {
                if (isPrimeNumber(integerList.get(i))) {
                    countTail.getAndIncrement();
                    System.out.println("В потоке Tail - " + integerList.get(i));
                }
            }
        };

        Thread threadHead = new Thread(runnableHead);
        Thread threadTail = new Thread(runnableTail);
        threadHead.start();
        threadTail.start();
        try {
            threadHead.join();
            threadTail.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int sum = countHead.get() + countTail.get();
        System.out.println("Простых чисел в листе: " + sum);
    }

    public static boolean isPrimeNumber(Integer integer) {
        boolean isPrimeNumber = true;
        if (integer == 1) {
            return false;
        }
        for (int i = 2; i < integer; i++) {
            if (integer % i == 0) {
                isPrimeNumber = false;
                break;
            }
        }
        return isPrimeNumber;
    }

    // Try out it
    static boolean fastIsPrimeNumber(Integer integer) {
        if (integer == 1) {
            return false;
        }
        BigInteger bigInteger = BigInteger.valueOf(integer);
        return bigInteger.isProbablePrime((int) Math.log(integer));
    }
}
