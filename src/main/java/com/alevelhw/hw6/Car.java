package com.alevelhw.hw6;

public class Car {
    private String manufacturer;
    private int engine;
    private String color;
    private int petrol;

    public Car() {
    }

    public Car(String manufacturer, int engine, String color) {
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.color = color;
        this.petrol = 100;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getEngine() {
        return engine;
    }

     public void setEngine(int engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPetrol() {
        return petrol;
    }

    public void setPetrol(int petrol) {
        this.petrol = petrol;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", engine=" + engine +
                ", color='" + color + '\'' +
                ", petrol=" + petrol +
                '}';
    }

    public boolean isEnoughPetrolLevel() {
        return petrol > 50;
    }

    public void startEngine(String name) {
        System.out.println(name + " запустил двигатель");
    }
}
