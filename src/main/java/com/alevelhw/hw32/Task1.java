package com.alevelhw.hw32;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task1 {
    private static int counter = 50;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Lock lock = new ReentrantLock();

        Runnable runnable = () -> {
            lock.lock();
            counter += 2;
            lock.unlock();
        };

        for (int i = 0; i < 100; i++) {
            executorService.submit(runnable);
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("counter = " + counter);
    }
}

