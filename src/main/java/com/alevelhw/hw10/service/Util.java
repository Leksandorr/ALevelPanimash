package com.alevelhw.hw10.service;

import com.alevelhw.hw10.model.*;

import java.util.Arrays;
import java.util.Random;

public class Util {
    protected static Random random = new Random();
    protected static int minPhoneNumber = 1;
    protected static int maxFirstPhoneNumber = 2;
    protected static int maxWirePhoneNumber = 999_999;
    protected static int maxCellPhoneNumber = 9_999_999;
    protected static int maxSmartPhoneNumber = maxCellPhoneNumber;

    public static void setPhoneNumber(Phone phone) {
        if (phone.getType().equals("FirstPhone")) {
            phone.setPhoneNumber(random.nextInt
                    (maxFirstPhoneNumber - minPhoneNumber + 1) + minPhoneNumber);
        }
        if (phone.getType().equals("WirePhone")) {
            phone.setPhoneNumber(random.nextInt
                    (maxWirePhoneNumber - minPhoneNumber + 1) + minPhoneNumber);
        }
        if (phone.getType().equals("CellPhone") || phone.getType().equals("SmartPhone")) {
            phone.setPhoneNumber(random.nextInt
                    (maxCellPhoneNumber - minPhoneNumber + 1) + minPhoneNumber);
        }
    }

    public static void testPhone(Phone phone) {
        System.out.println();
        System.out.println("На тест поступил телефон");
        System.out.println(phone);

        System.out.println("Проверка исходящих звонков");
        phone.call(1);
        System.out.println("Проверка входящих звонков");
        phone.ring(2);
        if (phone.getType().equals("CellPhone")) {
            CellPhone cellPhone = (CellPhone) phone;
            System.out.println("Проверка исходящих SMS");
            cellPhone.sendSms(1);
            System.out.println("Проверка входящих SMS");
            cellPhone.receiveSms(2, "Hello!");
            System.out.println(Arrays.toString(cellPhone.getSms()));
        }
        if (phone.getType().equals("SmartPhone")) {
            SmartPhone smartPhone = (SmartPhone) phone;
            System.out.println("Проверка исходящих SMS");
            smartPhone.sendSms(1);
            System.out.println("Проверка входящих SMS");
            smartPhone.receiveSms(2, "Hello!");
            System.out.println(Arrays.toString(smartPhone.getSms()));
            System.out.println("Проверка котиков");
            smartPhone.watchCats();
        }

    }

    public static void breakPhone(Phone phone) {
        System.out.println("Ломаем телефон");
        System.out.println(phone);

        phone.setManufacturer("");
        phone.setYear(2025);
        phone.setPhoneNumber(-1);

        if (phone.getType().equals("CellPhone")) {
            CellPhone cellPhone = (CellPhone) phone;
            cellPhone.setSms(new String[2]);
        }
        if (phone.getType().equals("SmartPhone")) {
            SmartPhone smartPhone = (SmartPhone) phone;
            smartPhone.setSms(new String[2]);
            smartPhone.setCats("https://www.google.com/search?q=%D0%BF%D0%B5%D1%81%D0%B8%D0%BA%D0%B8&rlz=1C1SQJL_ruUA971UA971&source=lnms&tbm=isch&sa=X&ved=2ahUKEwj86umtm7v0AhUKuosKHUkPBCsQ");
        }
    }

    public static FirstPhone getStandardFirstPhone() {
        return new FirstPhone(1);
    }

    public static WirePhone getStandardWirePhone() {
        return new WirePhone("Philips", 1995, 256471);
    }

    public static CellPhone getStandardCellPhone() {
        return new CellPhone("Samsung",2008, 8547963);
    }

    public static SmartPhone getStandardSmartPhone() {
        return new SmartPhone("Xiaomi", 2020, 8547963);
    }
}
