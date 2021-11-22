package com.alevelhw.hw7.service;

import com.alevelhw.hw7.action.*;
import com.alevelhw.hw7.model.*;

import java.util.Scanner;

public class UserActionsService {
    private final Scanner scanner = new Scanner(System.in);
    private final Food food = new Food();
    private final Work work = new Work();
    private final Game game = new Game();
    private final Shop shop = new Shop();
    private final Cure cure = new Cure();

    private final String suggestionToChoice = "Выберите одно из предложенных действий";
    private String userActionString;
    private int userAction;

    public Animal getAnimalTypeAndName() {
        System.out.println("Доступные типы персонажа:");
        final AnimalType[] values = AnimalType.values();
        StringBuilder animalTypeString = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            animalTypeString.append(i).append(") ")
                    .append(values[i]).append("\n");
        }
        System.out.println(animalTypeString);

        boolean isFit = true;
        do {
            System.out.println("Введите номер питомца:");
            userActionString = scanner.next();
            if (isNumber(userActionString)) {
                userAction = Integer.parseInt(userActionString);
                if (userAction > 0 && userAction <= values.length) {
                    isFit = false;
                }
            }
        } while (isFit);

        do {
            System.out.println("Введите имя питомца от 3 до 20 символов:");
            userActionString = scanner.next();
        } while (userActionString.length() < 3 || userActionString.length() > 20);

        return new Animal(userActionString, values[userAction]);
    }

    public void doActions(Animal animal) {
        StringBuilder builder = new StringBuilder("Выберите действие:\n");
        builder.append(0).append(") Выйти\n");
        builder.append(1).append(") Кормить\n");
        builder.append(2).append(") Работать\n");
        builder.append(3).append(") Играть\n");
        builder.append(4).append(") Магазин\n");
        builder.append(5).append(") Лечение\n");
        builder.append(6).append(") Статус");

        do {
            System.out.println(animal);
            System.out.println(builder);
            userActionString = scanner.next();
            if (isNumber(userActionString)) {
                userAction = Integer.parseInt(userActionString);
                if (userAction > -1 && userAction < 7) {
                    switch (userAction) {
                        case 0: {
                            System.exit(0);
                        }
                        case 1: {
                            food.doAction(animal);
                            break;
                        }
                        case 2: {
                            work.doAction(animal);
                            break;
                        }
                        case 3: {
                            game.doAction(animal);
                            break;
                        }
                        case 4: {
                            goShop(animal);
                            break;
                        }
                        case 5: {
                            cure.doAction(animal);
                            break;
                        }
                        case 6: {
                            animal.showStatus();
                            break;
                        }
                        default: {
                            throw new IllegalStateException();
                        }
                    }
                } else {
                    System.out.println(suggestionToChoice);
                }
            } else {
                System.out.println(suggestionToChoice);
            }
        } while (true);
    }

    private void goShop(Animal animal) {
        StringBuilder builder = new StringBuilder("Выберете подарок:\n");
        builder.append(0).append(") Выйти из магазина\n");
        builder.append(1).append(") Подарок за 100 монет увеличит счастье на 20\n");
        builder.append(2).append(") Подарок за 150 монет увеличит счастье на 25\n");
        builder.append(3).append(") Подарок за 200 монет увеличит счастье на 30");

        do {
            System.out.println(animal);
            System.out.println(builder);
            userActionString = scanner.next();
            if (isNumber(userActionString)) {
                userAction = Integer.parseInt(userActionString);
                if (userAction > -1 && userAction < 4) {
                    switch (userAction) {
                        case 0: {
                            doActions(animal);
                        }
                        case 1: {
                            Gift gift = new Gift(GiftType.GIFT100);
                            shop.doAction(gift, animal);
                            break;
                        }
                        case 2: {
                            Gift gift = new Gift(GiftType.GIFT150);
                            shop.doAction(gift, animal);
                            break;
                        }
                        case 3: {
                            Gift gift = new Gift(GiftType.GIFT200);
                            shop.doAction(gift, animal);
                            break;
                        }
                        default: {
                            throw new IllegalStateException();
                        }
                    }
                } else {
                    System.out.println(suggestionToChoice);
                }
            } else {
                System.out.println(suggestionToChoice);
            }
        } while (true);
    }

    private static boolean isNumber(String string) {
        boolean isNumber = false;
        for (char c : string.toCharArray()) {
            if (Character.isDigit(c)) {
                isNumber = true;
            } else {
                isNumber = false;
                break;
            }
        }
        return isNumber;
    }
}
