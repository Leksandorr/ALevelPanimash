package com.alevelhw.hw10;

import com.alevelhw.hw10.model.CellPhone;
import com.alevelhw.hw10.model.FirstPhone;
import com.alevelhw.hw10.model.SmartPhone;
import com.alevelhw.hw10.model.WirePhone;
import com.alevelhw.hw10.service.FixPhoneService;
import com.alevelhw.hw10.service.Util;

public class Main {
    public static void main(String[] args) {
        FixPhoneService fixPhoneService = new FixPhoneService();

        System.out.println("Создаем телефоны");
        FirstPhone firstPhone = new FirstPhone(1);
        WirePhone wirePhone = new WirePhone("Philips", 1995, 256471);
        CellPhone cellPhone = new CellPhone("Samsung",2008, 8547963);
        SmartPhone smartPhone = new SmartPhone("Xiaomi", 2020, 8547963);

        System.out.println(firstPhone);
        System.out.println(wirePhone);
        System.out.println(cellPhone);
        System.out.println(smartPhone);
        System.out.println();

        Util.breakPhone(firstPhone);
        Util.breakPhone(wirePhone);
        Util.breakPhone(cellPhone);
        Util.breakPhone(smartPhone);
        System.out.println();

        System.out.println("Сломанные телефоны");
        System.out.println(firstPhone);
        System.out.println(wirePhone);
        System.out.println(cellPhone);
        System.out.println(smartPhone);
        System.out.println();

        System.out.println("Чиним телефоны");
        fixPhoneService.fixPhone(firstPhone);
        fixPhoneService.fixPhone(wirePhone);
        fixPhoneService.fixPhone(cellPhone);
        fixPhoneService.fixPhone(smartPhone);

        System.out.println();
        System.out.println("Починенные телефоны");
        System.out.println(firstPhone);
        System.out.println(wirePhone);
        System.out.println(cellPhone);
        System.out.println(smartPhone);
        System.out.println();
        System.out.println("Тестируем телефоны");

        Util.testPhone(firstPhone);
        Util.testPhone(wirePhone);
        Util.testPhone(cellPhone);
        Util.testPhone(smartPhone);
        System.out.println();
        System.out.println("Протестированные телефоны");
        System.out.println(firstPhone);
        System.out.println(wirePhone);
        System.out.println(cellPhone);
        System.out.println(smartPhone);
        System.out.println();
        System.out.println("Сравниваем телефоны equals");

        System.out.println(firstPhone.equals(Util.getStandardFirstPhone()));
        System.out.println(wirePhone.equals(Util.getStandardWirePhone()));
        System.out.println(cellPhone.equals(Util.getStandardCellPhone()));
        System.out.println(smartPhone.equals(Util.getStandardSmartPhone()));
        System.out.println();
        System.out.println("Сравниваем телефоны hashCode");

        System.out.println(firstPhone.hashCode() == Util.getStandardFirstPhone().hashCode());
        System.out.println(wirePhone.hashCode() == Util.getStandardWirePhone().hashCode());
        System.out.println(cellPhone.hashCode() == Util.getStandardCellPhone().hashCode());
        System.out.println(smartPhone.hashCode() == Util.getStandardSmartPhone().hashCode());
        System.out.println();
        System.out.println("Делаем телефоны одинаковыми");

        firstPhone.setManufacturer("Bell");
        firstPhone.setYear(1876);
        firstPhone.setPhoneNumber(1);

        wirePhone.setManufacturer("Philips");
        wirePhone.setYear(1995);
        wirePhone.setPhoneNumber(256471);

        cellPhone.setManufacturer("Samsung");
        cellPhone.setYear(2008);
        cellPhone.setPhoneNumber(8547963);
        cellPhone.clearSms();

        smartPhone.setManufacturer("Xiaomi");
        smartPhone.setYear(2020);
        smartPhone.setPhoneNumber(8547963);
        smartPhone.clearSms();

        System.out.println(firstPhone);
        System.out.println(wirePhone);
        System.out.println(cellPhone);
        System.out.println(smartPhone);
        System.out.println();
        System.out.println("Эталонные телефоны");

        System.out.println(Util.getStandardFirstPhone());
        System.out.println(Util.getStandardWirePhone());
        System.out.println(Util.getStandardCellPhone());
        System.out.println(Util.getStandardSmartPhone());
        System.out.println();
        System.out.println("Сравниваем одинаковые телефоны equals");

        System.out.println(firstPhone.equals(Util.getStandardFirstPhone()));
        System.out.println(wirePhone.equals(Util.getStandardWirePhone()));
        System.out.println(cellPhone.equals(Util.getStandardCellPhone()));
        System.out.println(smartPhone.equals(Util.getStandardSmartPhone()));
        System.out.println();
        System.out.println("Сравниваем одинаковые телефоны hashCode");

        System.out.println(firstPhone.hashCode() == Util.getStandardFirstPhone().hashCode());
        System.out.println(wirePhone.hashCode() == Util.getStandardWirePhone().hashCode());
        System.out.println(cellPhone.hashCode() == Util.getStandardCellPhone().hashCode());
        System.out.println(smartPhone.hashCode() == Util.getStandardSmartPhone().hashCode());

    }
}
