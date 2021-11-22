package com.alevelhw.hw7.action;

import com.alevelhw.hw7.model.Animal;

public class Food {
    public void doAction(Animal animal) {
        final int dropPurity = 2;
        final int upHunger = 5;
        final double totalNegativeEffect = animal.getTotalNegativeEffect();
        final String name = animal.getName();

        if (animal.getPurity() > dropPurity * totalNegativeEffect) {
            animal.addPurity(-dropPurity * totalNegativeEffect);
        }
        else {
            System.out.println(name + " невероятно грязен, настолько, что его невозможно покормить");
            return;
        }

        animal.addHunger(upHunger);

        if (animal.isPure()) {
            System.out.println(name + " испачкался.");
        }
    }
}