package com.alevelhw.hw3.service;

import com.alevelhw.hw3.model.Numbers;
import com.alevelhw.hw3.model.Sign;

public class UserActionOperationService {
    double result;

    public double doAction(Sign sign, Numbers numbers) {
        switch (sign.getSign()) {
            case '+': {
                result = numbers.getNumberFirst() + numbers.getNumberSecond();
                break;
            }
            case '-': {
                result = numbers.getNumberFirst() - numbers.getNumberSecond();
                break;
            }
            case '*': {
                result = numbers.getNumberFirst() * numbers.getNumberSecond();
                break;
            }
            case '/': {
                if (numbers.getNumberSecond() == 0){
                    throw new IllegalArgumentException();
                }
                else {
                    result = numbers.getNumberFirst() / numbers.getNumberSecond();
                }
                break;
            }
        }
        return result;
    }
}
