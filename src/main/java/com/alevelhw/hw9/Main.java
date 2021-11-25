package com.alevelhw.hw9;

import com.alevelhw.hw9.model.PassengerCar;
import com.alevelhw.hw9.model.Recoverable;
import com.alevelhw.hw9.model.Truck;
import com.alevelhw.hw9.service.UserActionService;

public class Main {
    public static void main(String[] args) {
        UserActionService userActionService = new UserActionService();
        userActionService.gettingTypeCar();
//        PassengerCar passengerCar = new PassengerCar("bmw66", 2021, "Green");
        Truck truck = new Truck("bmw77", 2021, "Green");
        userActionService.userActionTruck(truck);

        Recoverable recoverable = new Recoverable() {
            @Override
            public void refuel() {
                System.out.println("Здравствуйте. Я заправщик. И я заправляю.");
            }
        };

        recoverable.refuel();
    }
}
