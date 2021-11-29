package com.alevelhw.hw10.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WirePhone extends Phone{

    public WirePhone(String manufacturer, int year, int phoneNumber) {
        super("WirePhone", manufacturer, year, phoneNumber);
    }

    @Override
    public void call(int outputNumber) {
        System.out.printf("Вызываю абонента #%d\n", outputNumber);
    }

    @Override
    public void ring(int inputNumber) {
        System.out.printf("Б-ззз, Б-ззз! Звонит абонент #%d\n", inputNumber);
    }

}
