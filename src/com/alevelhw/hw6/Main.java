package com.alevelhw.hw6;

public class Main {
    public static void main(String[] args) {
        forSevenPoint();
        forTenPoint();
    }

    private static void forSevenPoint() {
        Car mercedes = new Car();
        mercedes.setManufacturer("Mercedes");
        mercedes.setColor("White");
        mercedes.setEngine(2);
        mercedes.setPetrol(60);

        Car bmw = new Car();
        bmw.setManufacturer("BMW");
        bmw.setColor("Black");
        bmw.setEngine(3);
        bmw.setPetrol(40);

        Car porsche = new Car();
        porsche.setManufacturer("Porsche");
        porsche.setColor("Red");
        porsche.setEngine(3);
        porsche.setPetrol(100);

        System.out.println(mercedes);
        System.out.println(bmw);
        System.out.println(porsche);

        System.out.println("В Мерседесе достаточно топлива?");
        System.out.println(mercedes.isEnoughPetrolLevel());
        mercedes.startEngine("Mercedes");

        System.out.println("В BMW достаточно топлива?");
        System.out.println(bmw.isEnoughPetrolLevel());

        System.out.println("В Porsche достаточно топлива?");
        System.out.println(porsche.isEnoughPetrolLevel());
        porsche.startEngine("Porsche");
    }

    private static void forTenPoint() {
        Engine hydrogen = new Engine(950, "Hydrogen");
        CarForTenPoint bmw = new CarForTenPoint(Manufacturer.BMW, hydrogen, "Silver");
        Engine diesel = new Engine(700, "Diesel");
        CarForTenPoint mercedes = new CarForTenPoint(Manufacturer.MERCEDES, diesel, "White");
        Engine gas = new Engine(500, "Gas");
        CarForTenPoint porsche = new CarForTenPoint(Manufacturer.PORSCHE, gas, "Violet");
        Engine electrical = new Engine(1000, "Electrical");
        CarForTenPoint toyota = new CarForTenPoint(Manufacturer.TOYOTA, electrical, "Green");
        System.out.println(bmw);
        Garage.checkCar(bmw);
        System.out.println();

        System.out.println("Мерсередс утром " + mercedes);
        Garage.checkCar(mercedes);
        mercedes.setPetrol(45);
        System.out.println("Мерседес вечером " + mercedes);
        Garage.checkCar(mercedes);
        System.out.println();

        System.out.println("Порш новенький " + porsche);
        Garage.checkCar(porsche);
        porsche.setPetrol(30);
        gas.setPower(100);
        System.out.println("Порш спустя годы... " + porsche);
        Garage.checkCar(porsche);

        porsche.setEngine(electrical);
        porsche.setPetrol(100);
        System.out.println("Порш после замены двигателя " + porsche);
        Garage.checkCar(porsche);
        System.out.println();

        System.out.println("Тойота утром " + toyota);
        Garage.checkCar(toyota);
        toyota.setPetrol(20);
        System.out.println("Тойота вечером " + toyota);
        Garage.checkCar(toyota);
        System.out.println();
    }
}
