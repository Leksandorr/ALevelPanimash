package com.alevelhw.hw10.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FirstPhone extends Phone{

    public FirstPhone(int phoneNumber) {
        super("FirstPhone", "Bell", 1876, phoneNumber);
    }

    @Override
    public void call(int outputNumber) {
        System.out.println("Do you understand what I say?");
    }

    @Override
    public void ring(int inputNumber) {
        System.out.println("Б-ззз, Б-ззз!");
    }

}
