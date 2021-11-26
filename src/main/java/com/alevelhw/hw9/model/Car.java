package com.alevelhw.hw9.model;

public abstract class Car {
    final String series;
    final int year;
    final int fuelConsumption = 7;
    String color;
    int fuel;
    int countMoving = 0;
    boolean isNotEmptyTank = true;

    public Car(String series, int year, String color) {
        this.series = series;
        this.year = year;
        this.color = color;
        this.fuel = 100;
    }

    public void addFuel(int fuel) {
        this.fuel += fuel;
        isNotEmptyTank = this.fuel >= fuelConsumption;
    }

    public void move() {
        if (isNotEmptyTank) {
            addFuel(-fuelConsumption);
            ++countMoving;
            System.out.println("Поехали!");
        }
        else {
            System.out.println("Приехали");
        }
    }

    public abstract void showStatistic();
}
