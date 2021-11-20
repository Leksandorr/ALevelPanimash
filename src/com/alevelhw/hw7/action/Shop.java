package com.alevelhw.hw7.action;

import com.alevelhw.hw7.model.Animal;
import com.alevelhw.hw7.model.Gift;

public class Shop {
    public void doAction(Gift gift, Animal animal) {
        final int price = gift.getPrice();

        if (price > animal.getMoney()) {
            System.out.println("Надо больше денег");
        }
        else {
            animal.addMoney(-price);
            animal.addHappy(gift.getAddHappy());
            System.out.println("Вы купили подарок " + gift);
            animal.addGiftToCollection(gift);
        }
    }
}
