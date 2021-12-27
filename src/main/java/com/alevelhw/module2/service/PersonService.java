package com.alevelhw.module2.service;

import com.alevelhw.module2.model.Customer;
import com.alevelhw.module2.util.Util;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Getter
public class PersonService {
    private final Random random = new Random();
    private final List <Integer> ids = new LinkedList<>();

    public Customer getNewCustomer() {
        boolean flag = false;
        int minBoundId = 1;
        int maxBoundId = 1_000_000;
        int id;
        if (ids.size() != 0) {
            do {
                id = Util.getRandomInt(minBoundId, maxBoundId);
                for (Integer integer : ids) {
                    if (integer == id) {
                        flag = true;
                        break;
                    }
                    else {
                        flag = false;
                    }
                }
            } while (flag);
        } else {
            id = Util.getRandomInt(minBoundId, maxBoundId);
        }
        ids.add(id);
        int minBoundAge = 10;
        int maxBoundAge = 100;
        return new Customer(id, getRandomEmail(), Util.getRandomInt(minBoundAge, maxBoundAge));
    }

    private String getRandomEmail() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int minBoundStringLength = 3;
        int maxBoundStringLength = 8;
        int targetLength = Util.getRandomInt(minBoundStringLength, maxBoundStringLength);
        StringBuilder builder = new StringBuilder(targetLength);
        for (int i = 0; i < targetLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            builder.append((char) randomLimitedInt);
        }
        builder.append('@');
        targetLength = Util.getRandomInt(minBoundStringLength, maxBoundStringLength);
        for (int i = 0; i < targetLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            builder.append((char) randomLimitedInt);
        }
        builder.append(".com");
        return builder.toString();
    }

}
