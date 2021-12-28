package com.alevelhw.module2.util;

import java.util.Random;

public class Util {
    private static final Random random = new Random();

    public static int getRandomInt(int minBound, int maxBound) {
        return random.nextInt(maxBound - minBound + 1) + minBound;
    }
}
