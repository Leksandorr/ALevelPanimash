package com.alevelhw.hw7.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Animal {
    private final Random random = new Random();
    private final String name;
    private final AnimalType type;
    private int age;
    private int money;
    private double hunger;
    private double purity;
    private double happy;
    private boolean isUnhappy;
    private boolean isUnhappyToWork;
    private boolean isIll;
    private boolean isHunger;
    private boolean isPure;
    private Gift[] giftsCollection;

    public Animal(String name, AnimalType type) {
        this.name = name;
        this.type = type;
        this.age = 1;
        this.hunger = 100;
        this.money = 0;
        this.purity = 100;
        this.happy = 50;
    }

    public String getName() {
        return name;
    }

    public void addAge(int age) {
        this.age += age;
    }

    public int getAge() {
        return age;
    }

    public boolean isHunger() {return isHunger;}

    public void addHunger(double hunger) {
        this.hunger += hunger;
        isHunger = this.hunger < 50;
    }

    public double getHunger() {
        return hunger;
    }

    public void setHunger(double hunger) {
        this.hunger = hunger;
        isHunger = this.hunger < 50;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public int getMoney() {
        return money;
    }

    public void addPurity(double purity) {
        this.purity += purity;
        isPure = this.purity < 50;
    }

    public double getPurity() {
        return purity;
    }

    public void setPurity(double purity) {
        this.purity = purity;
        isPure = this.purity < 50;
    }

    public boolean isPure() {
        return isPure;
    }

    public boolean isIll() {
        return isIll;
    }

    public void setIll(boolean ill) {
        isIll = ill;
    }

    public void addHappy(double happy) {
        this.happy += happy;
        isUnhappy = this.happy < 10;
        isUnhappyToWork = this.happy < 20;
    }

    public void setHappy(double happy) {
        this.happy = happy;
        isUnhappy = this.happy < 10;
        isUnhappyToWork = this.happy < 20;
    }

    public boolean isUnhappy() {
        return isUnhappy;
    }

    public boolean isUnhappyToWork() {
        return isUnhappyToWork;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "Имя='" + name + '\'' +
                ", Вид=" + type +
                ", Возраст=" + age +
                ", Сытость=" + hunger +
                ", Деньги=" + money +
                ", Чистота=" + purity +
                ", Счастье=" + happy +
                '}';
    }

    public void addGiftToCollection(Gift gift) {
        int emptyIndex = 0;
        if (Objects.equals(giftsCollection, null)) {
            giftsCollection = new Gift[4];
        }
        for (int i = 0; i < giftsCollection.length; i++) {
            if (Objects.equals(giftsCollection[i], null)) {
                emptyIndex = i;
                break;
            }
        }
        if ((giftsCollection.length - emptyIndex) == 1) {
            Gift[] copyGiftsCollection = Arrays.copyOf(giftsCollection,
                    giftsCollection.length + giftsCollection.length / 2);
            giftsCollection = Arrays.copyOf(copyGiftsCollection, copyGiftsCollection.length);
        }
        giftsCollection[emptyIndex] = gift;
    }

    public void getIllness() {
        int randomNumber = random.nextInt(100);
        int chanceGetIllness = 10;
        int increaseChanceGetIllness = 3;

        if (isPure) {
            if (randomNumber <= chanceGetIllness * increaseChanceGetIllness) {
                setIll(true);
                System.out.println(name + " заболел(а). Необходимо лечение");
            }
        }
        else {
            if (randomNumber <= chanceGetIllness) {
                setIll(true);
                System.out.println(name + " заболел(а). Необходимо лечение");
            }
        }
    }

    public void earnMoney(int minBoundAddMoney, int maxBoundAddMoney) {
        addMoney(random.nextInt
                (maxBoundAddMoney - minBoundAddMoney + 1) + minBoundAddMoney);
    }

    public double getTotalNegativeEffect() {
        final double unHappyNegativeEffect = 1.2;
        final double hungerNegativeEffect = 1.5;
        final double illnessNegativeEffect = 2;
        double totalNegativeEffect = 1;

        if (isUnhappy) {
            totalNegativeEffect *= unHappyNegativeEffect;
        }
        if (isHunger) {
            totalNegativeEffect *= hungerNegativeEffect;
        }
        if (isIll) {
            totalNegativeEffect *= illnessNegativeEffect;
        }
        return totalNegativeEffect;
    }

    public void showStatus() {
        StringBuilder builder = new StringBuilder();

        if (isUnhappy) {
            builder.append(name).append(" несчастен(а). Все отрицательные эффекты работают в 1,2 раза сильнее\n");
        }
        else {
            builder.append(name).append(" счастлив(а)\n");
        }
        if (isHunger) {
            builder.append(name).append(" голоден(а). Все отрицательные эффекты работают в 1,5 раза сильнее\n");
        }
        else {
            builder.append(name).append(" не голоден(а)\n");
        }
        if (isIll) {
            builder.append(name).append(" болен(а). Все отрицательные эффекты работают в 2 раза сильнее\n");
        }
        else {
            builder.append(name).append(" не болеет\n");
        }
        if ((isUnhappy && isHunger) ||
                (isUnhappy && isIll) ||
                (isIll && isHunger)) {
            builder.append("Суммарный отрицательный эффект в ").append(getTotalNegativeEffect()).append(" раза сильнее\n");
        }
        if (isUnhappyToWork) {
            builder.append("Счастье ниже 20. ").append(name).append(" не может работать\n");
        }
        if (isPure) {
            builder.append(name).append(" испачкался(ась). Шанс заболеть увеличен в 3 раза\n");
        }
        if (Objects.equals(giftsCollection, null)) {
            builder.append("В коллекции нет подарков");
        }
        else {
            builder.append("Коллекция подарков: ").append(Arrays.toString(giftsCollection));
        }

        System.out.println(builder);
    }
}
