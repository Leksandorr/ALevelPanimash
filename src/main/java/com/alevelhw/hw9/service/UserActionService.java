package com.alevelhw.hw9.service;

import com.alevelhw.hw9.model.Passenger;
import com.alevelhw.hw9.model.PassengerCar;
import com.alevelhw.hw9.model.Truck;

import java.util.Scanner;

public class UserActionService {
    private Scanner scanner = new Scanner(System.in);
    private PassengerCar passengerCar;
    private Truck truck;
    Passenger passenger;

    public void gettingTypeCar() {
        System.out.println("Введите 1 для создания легкового авто или 2 для создания грузовика");
        int typeCar = scanner.nextInt();
        String series;
        int year;
        String color;
        System.out.println("Введите серию авто");
        series = scanner.next();
        System.out.println("Введите год авто");
        year = scanner.nextInt();
        System.out.println("Введите цвет авто");
        color = scanner.next();

        switch (typeCar) {
            case 1: {
                passengerCar = new  PassengerCar(series, year, color);
                userActionPassengerCar(passengerCar);
            }
            case 2: {
                truck = new Truck(series, year, color);
                userActionTruck(truck);
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    public void userActionPassengerCar(PassengerCar passengerCar) {
        do {
            System.out.println("0 Выйти");
            System.out.println("1 Ехать");
            System.out.println("2 Заправить авто");
            System.out.println("3 Добавить пассажира");
            System.out.println("4 Высадить пассажира");
            System.out.println("5 Статистика");

            switch (scanner.nextInt()) {
                case 0: {
                    System.out.println("Работа программы завершена");
                    System.exit(0);
                }
                case 1: {
                    passengerCar.move();
                    break;
                }
                case 2: {
                    passengerCar.refuel();
                    break;
                }
                case 3: {
                    System.out.println("Введите имя пассажира");
                    scanner.nextLine();
                    String input = scanner.nextLine();
                    passenger = new Passenger(input);
                    passengerCar.addPassenger(passenger);
                    break;
                }
                case 4: {
                    passengerCar.removePassenger();
                }
                case 5: {
                    passengerCar.showStatistic();
                }
            }
        } while (true);
    }

    public void userActionTruck(Truck truck) {
        do {
            System.out.println("0 Выйти");
            System.out.println("1 Ехать");
            System.out.println("2 Заправить авто");
            System.out.println("3 Погрузить груз");
            System.out.println("4 Выгрузить груз");
            System.out.println("5 Статистика");

            switch (scanner.nextInt()) {
                case 0: {
                    System.out.println("Работа программы завершена");
                    System.exit(0);
                }
                case 1: {
                    truck.move();
                    break;
                }
                case 2: {
                    truck.refuel();
                    break;
                }
                case 3: {
                    System.out.println("Введите количество груза");
                    truck.loadCargo(scanner.nextInt());
                    break;
                }
                case 4: {
                    System.out.println("Введите количество груза");
                    truck.unloadCargo(scanner.nextInt());
                }
                case 5: {
                    truck.showStatistic();
                }
            }
        } while (true);
    }
}