package com.alevelhw.hw6;

public class CarForTenPoint{
    private final Manufacturer manufacturer;
    private Engine engine;
    private final String color;
    private int petrol;

    public CarForTenPoint(Manufacturer manufacturer, Engine engine, String color) {
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.color = color;
        this.petrol = 100;
    }

    public int getPetrol() {
        return petrol;
    }

    public void setPetrol(int petrol) {
        this.petrol = petrol;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
        System.out.println("Установлен двигатель " + engine);
    }

    @Override
    public String toString() {
        return "CarForTenPoint{" +
                "manufacturer='" + manufacturer.russianName + '\'' +
                ", engine=" + engine +
                ", color='" + color + '\'' +
                ", petrol=" + petrol +
                '}';
    }

    public boolean isEnoughPetrolLevel() {
        return petrol > 50;
    }
}
