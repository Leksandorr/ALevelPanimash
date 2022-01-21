package com.alevelhw.hw23.util;

import java.util.Random;

import static com.alevelhw.module2.util.Util.getRandomInt;

public class UtilHW23 {
    private static final Random random = new Random();

    public static String getRandomLatinString(int minBoundStringLength, int maxBoundStringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetLength = getRandomInt(minBoundStringLength, maxBoundStringLength);
        StringBuilder builder = new StringBuilder(targetLength);
        for (int i = 0; i < targetLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            builder.append((char) randomLimitedInt);
        }
        return builder.toString();
    }
}
