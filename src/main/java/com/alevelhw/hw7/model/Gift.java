package com.alevelhw.hw7.model;

import java.util.Random;

public class Gift {
    private static final Random random = new Random();
    private final String title = getTitle();
    private final int price;
    private final int addHappy;


    public Gift(GiftType giftType) {
        this.price = giftType.getPrice();
        this.addHappy = giftType.getAddHappy();
    }

    public int getPrice() {
        return price;
    }

    public int getAddHappy() {
        return addHappy;
    }

    private String getTitle() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int minBound = 3;
        int maxBound = 12;
        int targetNameLength = random.nextInt(maxBound - minBound + 1) + minBound;
        StringBuilder builder = new StringBuilder(targetNameLength);
        for (int i = 0; i < targetNameLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            builder.append((char) randomLimitedInt);
        }
        builder.insert(0, builder.
                substring(0, 1).toUpperCase());
        return builder.toString();
    }

    @Override
    public String toString() {
        return "Gift{" +
                "Название='" + title + '\'' +
                ", Цена=" + price +
                ", Добавляет счастья=" + addHappy +
                '}';
    }
}
