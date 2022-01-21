package com.alevelhw.hw24;

import com.alevelhw.hw23.repository.TablesFillRepository;
import com.alevelhw.hw24.entity.Device;
import com.alevelhw.hw24.entity.Factory;
import com.alevelhw.hw24.repository.DeviceRepository;
import com.alevelhw.hw24.repository.FactoryRepository;
import com.alevelhw.module2.util.Util;

import java.math.BigDecimal;
import java.text.ParseException;

public class Main {
    private static final TablesFillRepository tablesFillRepository = new TablesFillRepository();
    private static final FactoryRepository factoryRepository = new FactoryRepository();
    private static final DeviceRepository deviceRepository = new DeviceRepository();

    public static void main(String[] args) {

        fillDatabase(4, 10);

        System.out.println();
        Device device = deviceRepository.getDeviceById(1);
        System.out.println("+++++++++++++++++++ Устройство по ID +++++++++++++++++++");
        System.out.println(device);
        System.out.println();
        System.out.println("+++++++++++++++++++ Изменяем устройстово +++++++++++++++++++");
        device.setDescription("Изменённое устройство ");
        deviceRepository.updateDevice(device);
        System.out.println(deviceRepository.getDeviceById(1));
        System.out.println();
        System.out.println("+++++++++++++++++++ Удаляем устройстово +++++++++++++++++++");
        deviceRepository.deleteDevice(device);
        System.out.println(deviceRepository.getDeviceById(1));
        System.out.println();
        System.out.println("+++++++++++++++++++ Завод по ID +++++++++++++++++++");
        System.out.println(factoryRepository.getFactoryById(1));
        System.out.println();
        System.out.println("+++++++++++++++++++ Завод по другому ID +++++++++++++++++++");
        System.out.println(factoryRepository.getFactoryById(2));
        System.out.println();
        System.out.println("+++++++++++++++++++ Все устройства изготовленные на конкретном заводе +++++++++++++++++++");
        deviceRepository
                .getDevisesByFactory(factoryRepository.getFactoryById(1))
                .forEach(System.out::println);
        System.out.println();
        System.out.println("+++++++++++++++++++ Количество всех устройств по каждому заводу +++++++++++++++++++");
        System.out.println(deviceRepository.getTotalQuantityDevicesForEachFactory());
        System.out.println();
        System.out.println("+++++++++++++++++++ Общая стоимость всех устройств по каждому заводу +++++++++++++++++++");
        System.out.println(deviceRepository.getTotalCostDevicesForEachFactory());
    }

    public static void fillDatabase(int quantityFactories, int quantityDevices) {
        int counter = 0;
        while (counter < quantityFactories) {
            addRandomFactory();
            counter++;
        }
        counter = 0;
        while (counter < quantityDevices) {
            addRandomDevice();
            counter++;
        }
    }

    private static void addRandomFactory() {
        Factory factory = new Factory();
        factory.setName(tablesFillRepository.getRandomFactoryName());
        factory.setCountry(tablesFillRepository.getRandomCountry());
        factoryRepository.saveFactory(factory);
    }

    private static void addRandomDevice() {
        Device device = new Device();
        device.setType(tablesFillRepository.getRandomDeviceType());
        device.setModel(tablesFillRepository.getRandomModel());
        device.setPrice(BigDecimal.valueOf(Util.getRandomInt(150, 5000)));
        try {
            device.setDate(tablesFillRepository.getRandomDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        device.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        device.setAvailable(tablesFillRepository.getRandomBoolean());
        device.setFactory(factoryRepository
                .getFactoryById(tablesFillRepository
                        .getRandomFactoryId()));
        deviceRepository.saveDevice(device);
    }
}
