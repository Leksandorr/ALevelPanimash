package com.alevelhw.hw10.service;

import com.alevelhw.hw10.model.CellPhone;
import com.alevelhw.hw10.model.Phone;
import com.alevelhw.hw10.model.SmartPhone;

import java.util.Scanner;

public class FixPhoneService {
    private final Scanner scanner = new Scanner(System.in);
    private final int minYear = 1876;
    private final int maxYear = 2021;
    private final int quantitySmsCellPhone = 5;
    private final int quantitySmsSmartPhone = 10;
    private final String cats = "https://www.google.com/search?q=%D0%BA%D0%BE%D1%82%D0%B8%D0%BA%D0%B8&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjJxbTY0Lb0AhVi-SoKHcCJAIUQ";

    public void fixPhone(Phone phone) {
        System.out.println();
        System.out.println("На починку принят телефон");
        System.out.println(phone);
        if (phone.getManufacturer().equals("")) {
            System.out.println("Обнаружена поломка. Отсутствует производель. Введите производителя");
            boolean isFit = true;
            do {
                String userAction = scanner.nextLine();
                if (userAction.equals("")) {
                    System.out.println("Введите производителя");
                }
                else {
                    phone.setManufacturer(userAction);
                    isFit = false;
                }
            } while (isFit);
            System.out.println("Поломка устранена");
        }

        if (phone.getYear() < minYear || phone.getYear() > maxYear) {
            System.out.println("Обнаружена поломка. Неверный год. Введите год");
            boolean isFit = true;
            do {
                int userAction = scanner.nextInt();
                if (userAction >= minYear && userAction <= maxYear) {
                    phone.setYear(userAction);
                    isFit = false;
                }
                else {
                    System.out.println("Введите правильный год");
                }
            } while (isFit);
            System.out.println("Поломка устранена");
        }

        switch (phone.getType()) {
            case "FirstPhone":
                if (phone.getPhoneNumber() < Util.minPhoneNumber ||
                        phone.getPhoneNumber() > Util.maxFirstPhoneNumber) {
                    System.out.println("Обнаружена поломка. Неверный номер телефона");
                    Util.setPhoneNumber(phone);
                    System.out.println("Поломка устранена");
                }
                break;
            case "WirePhone":
                if (phone.getPhoneNumber() <= Util.minPhoneNumber ||
                        phone.getPhoneNumber() > Util.maxWirePhoneNumber) {
                    System.out.println("Обнаружена поломка. Неверный номер телефона");
                    Util.setPhoneNumber(phone);
                    System.out.println("Поломка устранена");
                }
                break;
            case "CellPhone":
                if (phone.getPhoneNumber() <= Util.minPhoneNumber ||
                        phone.getPhoneNumber() > Util.maxCellPhoneNumber) {
                    System.out.println("Обнаружена поломка. Неверный номер телефона");
                    Util.setPhoneNumber(phone);
                    System.out.println("Поломка устранена");
                }

                CellPhone cellPhone = (CellPhone) phone;
                if (cellPhone.getSms().length != quantitySmsCellPhone) {
                    System.out.println("Обнаружена поломка. Неверное кол-во памяти SMS");
                    cellPhone.setSms(new String[quantitySmsCellPhone]);
                    System.out.println("Поломка устранена");
                }
                break;
            case "SmartPhone":
                if (phone.getPhoneNumber() <= Util.minPhoneNumber ||
                        phone.getPhoneNumber() > Util.maxSmartPhoneNumber) {
                    System.out.println("Обнаружена поломка. Неверный номер телефона");
                    Util.setPhoneNumber(phone);
                    System.out.println("Поломка устранена");
                }

                SmartPhone smartPhone = (SmartPhone) phone;
                if (smartPhone.getSms().length != quantitySmsSmartPhone) {
                    System.out.println("Обнаружена поломка. Неверное кол-во памяти SMS");
                    smartPhone.setSms(new String[quantitySmsSmartPhone]);
                    System.out.println("Поломка устранена");
                }
                if (!smartPhone.getCats().equals(cats)) {
                    System.out.println("Обнаружена поломка. Отсутствуют котики");
                    smartPhone.setCats(cats);
                    System.out.println("Поломка устранена. Котики есть!");
                }
                break;
        }
    }
}
