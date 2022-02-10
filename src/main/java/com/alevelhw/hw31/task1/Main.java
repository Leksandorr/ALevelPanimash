package com.alevelhw.hw31.task1;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int numberThreads = 50;

        for (int i = 0; i < numberThreads; i++) {
            int finalI = i;

            Runnable runnable = () -> {
                try {
                    TimeUnit.SECONDS.sleep(numberThreads - finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hello from " + Thread.currentThread().getName());
            };

            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
