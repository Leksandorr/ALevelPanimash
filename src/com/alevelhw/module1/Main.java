package com.alevelhw.module1;

import com.alevelhw.module1.service.UserInputService;

public class Main {
    public static void main(String[] args) {
        UserInputService userInputService = new UserInputService();
        int[] array = userInputService.getArray();
        userInputService.getWayOfSort(array);
    }
}