package com.alevelhw.hw10.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@ToString
@Getter
@Setter
public abstract class Phone {
    protected String type;
    protected String manufacturer;
    protected int year;
    protected int phoneNumber;

    public Phone(String type, String manufacturer, int year, int phoneNumber) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.year = year;
        this.phoneNumber = phoneNumber;
    }

    public abstract void call(int outputNumber);

    public abstract void ring(int inputNumber);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return year == phone.year && phoneNumber == phone.phoneNumber && Objects.equals(type, phone.type) && Objects.equals(manufacturer, phone.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, manufacturer, year, phoneNumber);
    }
}
