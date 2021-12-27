package com.alevelhw.module2.exception;

public class IncorrectReadStringException extends Exception {
    private final String detail;

    public IncorrectReadStringException(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "IncorrectReadStringException{" +
                "detail='" + detail + '\'' +
                '}';
    }
}