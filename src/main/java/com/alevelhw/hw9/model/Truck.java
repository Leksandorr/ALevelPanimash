package com.alevelhw.hw9.model;

public class Truck extends Car implements Recoverable {
    private final int maxCargo = 100;
    private int cargo = 0;
    private final String TYPE = "truck";

    public Truck(String series, int year, String color) {
        super(series, year, color);
    }

    public void setFuel(int fuel) {
        super.fuel = fuel;
    }

    public void loadCargo(int cargo) {
        if (cargo > maxCargo - this.cargo) {
            System.out.printf("Сейчас можно загрузить не больше %d\n", maxCargo - this.cargo);
        }
        else if (cargo < 0) {
            System.out.println("Не надо так");
        }
        else {
            this.cargo += cargo;
        }
    }

    public void unloadCargo(int cargo) {
        if (cargo > this.cargo ) {
            System.out.printf("Сейчас груза %d\n", this.cargo);
        }
        else if (cargo < 0) {
            System.out.println("Не надо так");
        }
        else {
            this.cargo -= cargo;
        }

    }

    public String getTYPE() {
        return TYPE;
    }

    @Override
    public void move() {
        if (isNotEmptyTank) {
            addFuel(-fuelConsumption * 2);
            System.out.println("Поехали!");
        }
        else {
            System.out.println("Приехали");
        }
    }

    @Override
    public void addFuel(int fuel) {
        this.fuel += fuel;
        isNotEmptyTank = this.fuel >= fuelConsumption * 2;
    }

    @Override
    public void showStatistic() {
        System.out.printf("Авто серии %s %d-го года выпуска %s цвета.\n" +
                "В баке %d бензина.\n" +
                "Грузовик проехался %d раз\n" +
                "Грузовик загружен на %d процентов:\n",
                series, year, color, fuel, countMoving, cargo);
    }

    @Override
    public void refuel() {
        setFuel(100);
        System.out.println("Авто заправлено");
    }
}
