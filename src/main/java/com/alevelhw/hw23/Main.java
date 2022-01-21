package com.alevelhw.hw23;

import com.alevelhw.hw23.entity.Device;
import com.alevelhw.hw23.repository.ActionRepository;
import com.alevelhw.hw23.repository.TablesCreateRepository;
import com.alevelhw.hw23.repository.TablesFillRepository;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        TablesCreateRepository createRepositories = new TablesCreateRepository();
        createRepositories.createFactoryTableSQL();
        createRepositories.createDeviceTableSQL();
        TablesFillRepository generateRepositories = new TablesFillRepository();
        generateRepositories.fillDatabase(4, 10);

        ActionRepository actionRepository = new ActionRepository();
        Device device = actionRepository.getDeviceById(1);

        System.out.println("Устройство по ID");
        System.out.println(device);

        System.out.println("Изменяем устройстово");
        device.setDescription("Изменённое устройство");
        actionRepository.changeDevise(device);
        System.out.println(actionRepository.getDeviceById(1));

        System.out.println("Удаляем устройстово");
        actionRepository.deleteDevice(device);
        System.out.println(actionRepository.getDeviceById(1));

        System.out.println("Завод по ID");
        System.out.println(actionRepository.getFactoryById(1));

        System.out.println("Завод по другому ID");
        System.out.println(actionRepository.getFactoryById(2));

        System.out.println("Все устройства изготовленные на конкретном заводе");
        System.out.println(actionRepository.getDevisesByFactory(4));

        System.out.println("Количество всех устройств по каждому заводу");
        System.out.println(actionRepository.getTotalQuantityDevicesForEachFactory());

        System.out.println("Общая стоимость всех устройств по каждому заводу");
        System.out.println(actionRepository.getTotalCostDevicesForEachFactory());
    }
}
