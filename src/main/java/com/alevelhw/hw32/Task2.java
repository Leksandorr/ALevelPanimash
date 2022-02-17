package com.alevelhw.hw32;

import com.alevelhw.module2.util.Util;
import lombok.Getter;
import org.apache.commons.lang3.time.StopWatch;

import java.util.*;
import java.util.concurrent.*;

public class Task2 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Horse> horseList = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Введите количество лошадей в забеге");
        int numberHorses = scanner.nextInt();
        System.out.println("Введите номер лошади на которую делаете ставку");
        int numberHors = scanner.nextInt();

        ExecutorService executorService = Executors.newFixedThreadPool(numberHorses);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(numberHorses, () -> System.out.println("Забег окончен"));

        for (int i = 0; i < numberHorses; i++) {
            executorService.submit(new Horse(i + 1, cyclicBarrier));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1L, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        horseList.sort(Comparator.comparing(Horse::getTime));
        System.out.println(horseList);

        for (int i = 0; i < horseList.size(); i++) {
            if (horseList.get(i).getId() == numberHors) {
                System.out.println("Ваша лошадь заняла " + (i + 1) + " место");
            }
        }
    }

    @Getter
    static class Horse implements Runnable {
        private final int id;
        private Long time;
        private final StopWatch watch = new StopWatch();
        private final CyclicBarrier cyclicBarrier;

        public Horse(int id, CyclicBarrier cyclicBarrier) {
            this.id = id;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            int distance = 0;

            watch.start();
            do {
                distance += Util.getRandomInt(100, 200);
                try {
                    Thread.sleep(Util.getRandomInt(400, 500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (distance < 1000);
            watch.stop();

            time = watch.getNanoTime();
            horseList.add(this);
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "Horse{" +
                    "id=" + id +
                    ", time=" + time +
                    '}';
        }
    }
}
