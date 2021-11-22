package com.alevelhw.hw7.action;

import com.alevelhw.hw7.model.Animal;

public class Game {
    private int gameCount;

    public void doAction(Animal animal) {
        final int dropHunger = 3;
        final int upHappy = 6;
        final int quantityGameForUpAge = 5;
        final int upAge = 1;
        final int minBoundAddMoney = 1;
        final int maxBoundAddMoney = 10;
        final double totalNegativeEffect = animal.getTotalNegativeEffect();
        final String name = animal.getName();

        if (animal.getHunger() > dropHunger * totalNegativeEffect) {
            animal.addHunger(-dropHunger * totalNegativeEffect);
        } else {
            animal.addHunger(-dropHunger * totalNegativeEffect);
            System.out.println(animal + "\n" + name + " умирает от голода");
            System.exit(0);
        }

        animal.addHappy(upHappy);

        if (++gameCount == quantityGameForUpAge) {
            gameCount = 0;
            animal.addAge(upAge);
        }

        animal.earnMoney(minBoundAddMoney, maxBoundAddMoney);

        animal.getIllness();

        if (animal.isHunger()) {
            System.out.println(name + " голоден(а). Накормите " + name);
        }
    }
}
