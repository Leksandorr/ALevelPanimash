package com.alevelhw.hw7;

import com.alevelhw.hw7.model.Animal;
import com.alevelhw.hw7.model.AnimalType;
import com.alevelhw.hw7.service.UserActionsService;

public class Main {
    public static void main(String[] args) {
        UserActionsService userActionsService = new UserActionsService();
        final Animal animal = userActionsService.getAnimalTypeAndName();
        //final Animal animal = new Animal("Test", AnimalType.DOG);
        userActionsService.doActions(animal);
    }
}
