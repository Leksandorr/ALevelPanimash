package com.alevelhw.hw7.action;

import com.alevelhw.hw7.model.Animal;

public class Cure {
    public void doAction(Animal animal) {
        final int dropHappyTo = 10;
        final int dropHungerTo = 70;
        final int upPurityTo = 80;
        final int priceCure = 50;
        final String name = animal.getName();

        if (animal.isIll()) {
            if (animal.getMoney() >= priceCure) {
                animal.addMoney(-priceCure);
            }
            else {
                System.out.println("На лечение не хватает денег");
                return;
            }

            if (!animal.isUnhappy()) {
                animal.setHappy(dropHappyTo);
            }

            if (animal.getHunger() > dropHungerTo) {
                animal.setHunger(dropHungerTo);
            }

            if (animal.getPurity() < upPurityTo) {
                animal.setPurity(upPurityTo);
            }

            animal.setIll(false);

            System.out.println(name + " выздровел(а)\n" +
                    name + " несчастен и хочет есть");
        } else {
            System.out.println(name + " здоров. Лечение не требуется");
        }
    }
}
