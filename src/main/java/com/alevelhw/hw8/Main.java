package com.alevelhw.hw8;

import com.alevelhw.hw3.service.UserActionServiceVar1;
import com.alevelhw.hw3.service.UserActionServiceVar2;

import java.util.Scanner;
import static com.alevelhw.hw8.MyFirstUnitTest.countSumDigitsOfNumber;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String sNumber = scanner.nextLine();
        countSumDigitsOfNumber(sNumber);

        UserActionServiceVar1 calculator = new UserActionServiceVar1();
        //UserActionServiceVar2 calculator = new UserActionServiceVar2();
        calculator.calculator();
    }
}
