package com.alevelhw.hw7.action;

import com.alevelhw.hw7.model.Animal;

public class Work {
    private int workCount;

    public void doAction(Animal animal) {
        final int allowedWorkingAge = 5;
        final int dropHunger = 4;
        final int dropHappy = 2;
        final int minBoundAddMoney = 5;
        final int maxBoundAddMoney = 20;
        final int quantityWorkForUpAge = 6;
        final int upAge = 1;
        final double totalNegativeEffect = animal.getTotalNegativeEffect();
        final String name = animal.getName();

        if (animal.getAge() < allowedWorkingAge) {
            System.out.println(name + " ещё слишком мал для работы");
            return;
        }

        if (animal.isUnhappyToWork()) {
            System.out.println(name + " слишком несчастен, чтобы работать");
            return;
        }

        if (animal.getHunger() > dropHunger * totalNegativeEffect) {
            animal.addHunger(-dropHunger * totalNegativeEffect);
        }
        else {
            animal.addHunger(-dropHunger * totalNegativeEffect);
            System.out.println(animal + "\n" + name + " умирает от голода");
            System.exit(0);
        }

        animal.addHappy(-dropHappy * totalNegativeEffect);
        animal.earnMoney(minBoundAddMoney, maxBoundAddMoney);

        if (++workCount == quantityWorkForUpAge) {
            workCount = 0;
            animal.addAge(upAge);
        }

        animal.getIllness();

        if (animal.isHunger()) {
            System.out.println(name + " голоден(а). Накормите " + name);
        }
    }
}
