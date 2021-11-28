package com.alevelhw.hw10.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

@Getter
@Setter
public class SmartPhone extends Phone{
    private Scanner scanner = new Scanner(System.in);
    private String[] sms = new String[10];
    private String cats = "https://www.google.com/search?q=%D0%BA%D0%BE%D1%82%D0%B8%D0%BA%D0%B8&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjJxbTY0Lb0AhVi-SoKHcCJAIUQ";

    public SmartPhone(String manufacturer, int year, int phoneNumber) {
        super("SmartPhone", manufacturer, year, phoneNumber);
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "type='" + type + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                ", phoneNumber=" + phoneNumber +
                ", sms=" + Arrays.toString(sms) +
                ", cats='" + cats + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SmartPhone that = (SmartPhone) o;
        return Arrays.equals(sms, that.sms) && cats.equals(that.cats);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), cats);
        result = 31 * result + Arrays.hashCode(sms);
        return result;
    }

    @Override
    public void call(int outputNumber) {
        System.out.printf("Вызываю абонента №%d\n", outputNumber);
    }

    @Override
    public void ring(int inputNumber) {
        System.out.printf("Б-ззз, Б-ззз! Звонит абонент №%d\n", inputNumber);
    }

    public void receiveSms(int inputNumber, String string) {
        String s = "SMS от №" + inputNumber + ": " + string;
        for (int i = 0; i < sms.length; i++) {
            if (sms[i] == null) {
                sms[i] = s;
                break;
            }
            else {
                System.out.println("Память заполнена");
            }
        }
    }

    public String sendSms(int outputNumber) {
        System.out.println("Введите текст СМС");
        return scanner.nextLine();
    }

    public void clearSms() {
        for (int i = 0; i < sms.length; i++) {
            if (sms[i] != null) {
                sms[i] = null;
            }
        }
        System.out.println("Память SMS очищена");
    }

    public void watchCats() {
        System.out.println(cats);
    }
}
