package com.alevelhw.hw9.model;

import java.util.Arrays;

public class PassengerCar extends Car implements Recoverable {
    Passenger[] passengers = new Passenger[3];
    private final String TYPE = "passenger";
    private int quantityPassenger = 0;

    public PassengerCar(String series, int year, String color) {
        super(series, year, color);
    }

    public void setFuel(int fuel) {
        super.fuel = fuel;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void addPassenger(Passenger passenger) {
        if (quantityPassenger < passengers.length) {
            for (int i = 0; i < passengers.length; i++) {
                if (passengers[i] == null) {
                    passengers[i] = passenger;
                    ++quantityPassenger;
                    System.out.println("Пассажир добавлен");
                    break;
                }
            }
        }
        else {
            System.out.println("Места больше нет");
        }
    }

    public void removePassenger() {
        if (quantityPassenger > 0) {
            for (int i = 0; i < passengers.length; i++) {
                if (passengers[i] != null) {
                    passengers[i] = null;
                    --quantityPassenger;
                    System.out.println("Пассажир высажен");
                    break;
                }
            }
        }
        else {
            System.out.println("Пассажиров нет");
        }
    }

    @Override
    public void showStatistic() {
        System.out.printf("Авто серии %s %d-го года выпуска %s цвета.\n" +
                "В баке %d бензина\n" +
                "Авто проехалось %d раз\n" +
                "В машине %d пассажиров: ",
                series, year, color, fuel, countMoving, quantityPassenger);
        System.out.println(Arrays.toString(passengers));
    }

    @Override
    public void refuel() {
        setFuel(100);
        System.out.println("Авто заправлено");
    }
}
