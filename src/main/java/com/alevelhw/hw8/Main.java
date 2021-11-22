package com.alevelhw.hw8;

import com.alevelhw.hw3.service.UserActionService;
import java.util.Scanner;
import static com.alevelhw.hw8.MyFirstUnitTest.countSumDigitsOfNumber;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String sNumber = scanner.nextLine();
        countSumDigitsOfNumber(sNumber);

        UserActionService calculator = new UserActionService();
        calculator.calculator();
    }
}
