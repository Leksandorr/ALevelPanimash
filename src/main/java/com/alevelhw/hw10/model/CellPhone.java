package com.alevelhw.hw10.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Scanner;

@Getter
@Setter
public class CellPhone extends Phone{
    private Scanner scanner = new Scanner(System.in);
    private String[] sms;

    public CellPhone(String manufacturer, int year, int phoneNumber) {
        super("CellPhone", manufacturer, year, phoneNumber);
        this.sms = new String[5];
    }

    @Override
    public String toString() {
        return "CellPhone{" +
                "sms=" + Arrays.toString(sms) +
                ", type='" + type + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CellPhone cellPhone = (CellPhone) o;
        return Arrays.equals(sms, cellPhone.sms);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
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
}
