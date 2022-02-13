package com.alevelhw.module3.service;

import com.alevelhw.module3.entity.Sms;
import com.alevelhw.module3.repository.ActivityRepository;
import com.alevelhw.module3.repository.EquipmentRepository;
import com.alevelhw.module3.repository.SmsRepository;
import com.alevelhw.module3.util.Utils;

import java.util.List;
import java.util.Scanner;

public class UserActionService {
    private final Scanner scanner = new Scanner(System.in);
    private final SmsRepository smsRepository = new SmsRepository();
    private final ActivityRepository activityRepository = new ActivityRepository();
    private final EquipmentRepository equipmentRepository = new EquipmentRepository();

    public void doActions() {
        StringBuilder builder = new StringBuilder("Выберите действие:\n");
        builder.append(0).append(") Выйти\n");
        builder.append(1).append(") Поиск текста в хранилище СМС\n");
        builder.append(2).append(") Топ-5 абонентов сделавших больше всего звонков\n");
        builder.append(3).append(") Топ-5 абонентов отославших больше всего СМС\n");
        builder.append(4).append(") Топ-5 абонентов сделавших больше всего выходов в интернет\n");
        builder.append(5).append(") Самая популярная услуга\n");
        builder.append(6).append(") Самое популярное устройство в сети");

        do {
            System.out.println(builder);
            switch (scanner.next()) {
                case "0": {
                    System.exit(0);
                }
                case "1": {
                    System.out.println("Введите текст для поиска, например: plan to explode the president");
                    scanner.nextLine();
                    String input = scanner.nextLine();
                    List<Sms> smsList = smsRepository.fullTextSearchThroughSmsStorage(input);
                    if (smsList.size() == 0) {
                        System.out.println("Совпадений не найдено");
                    } else {
                        smsList.forEach(System.out::println);
                    }
                    break;
                }
                case "2": {
                    System.out.println("Больше всего звонков сделали:");
                    System.out.println(Utils.mapAsString(
                            activityRepository.getTopFiveConsumersOfActivity("Call")));
                    break;
                }
                case "3": {
                    System.out.println("Больше всего СМС отослали:");
                    System.out.println(Utils.mapAsString(
                            activityRepository.getTopFiveConsumersOfActivity("Sms")));
                    break;
                }
                case "4": {
                    System.out.println("Больше всего выходов в интернет сделали:");
                    System.out.println(Utils.mapAsString(
                            activityRepository.getTopFiveConsumersOfActivity("Internet")));
                    break;
                }
                case "5": {
                    System.out.println(activityRepository.getMostPopularActivity());
                    break;
                }
                case "6": {
                    System.out.println("Самое популярное устройство в сети: ");
                    System.out.println(Utils.mapAsString(
                            equipmentRepository.getMostPopularEquipment()));
                    break;
                }
            }
        } while (true);
    }
}
