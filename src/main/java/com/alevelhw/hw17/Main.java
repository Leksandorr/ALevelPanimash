package com.alevelhw.hw17;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static Random random = new Random();
    static Box box;
    static int minBoxSize = 200;
    static int maxBoxSize = 500;

    public static void main(String[] args) {
        System.out.println("------- Task 1 -------");
        String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};
        Stream<String> monthsStream = Arrays.stream(months);
        monthsStream.sorted().forEach(System.out::println);

        System.out.println("------- Task 2 -------");
        IntSummaryStatistics intSummaryStatistics = new IntSummaryStatistics();
        List<Integer> intList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            intList.add(getRandomInt(-50, 50));
        }
        Stream<Integer> integerStream = intList.stream();
        integerStream.forEach(System.out::println);
        integerStream = intList.stream();
        List<Integer> intListFiltered = integerStream.filter(x -> x >= 0).collect(Collectors.toList());
        for (Integer integer : intListFiltered) {
            intSummaryStatistics.accept(integer);
        }
        System.out.println("The count of values is: " + intSummaryStatistics.getCount());
        System.out.println("The average of values is: " + intSummaryStatistics.getAverage());
        System.out.println("The sum of values is: " + intSummaryStatistics.getSum());
        System.out.println("The maximum of values is: " + intSummaryStatistics.getMax());
        System.out.println("The min of values is: " + intSummaryStatistics.getMin());
        System.out.println("The string representation is: " + intSummaryStatistics);

        System.out.println("------- Task 3 -------");
        List<String> dateListString = new LinkedList<>();
        dateListString.add("2021/07/12");
        dateListString.add("2021/02/15");
        dateListString.add("2020/07/21");
        dateListString.add("1999/12/05");
        dateListString.add("2007/01/01");
        dateListString.add("2012/08/28");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println("Is there 2021: " + dateListString.stream()
                .map(x -> LocalDate.parse(x, dateTimeFormatter))
                .anyMatch(x -> x.getYear() == 2021));

        System.out.println("------- Task 4 -------");
        integerStream = intList.stream();
        Optional<Integer> min = integerStream.reduce((s1, s2) -> s1 < s2 ? s1 : s2);
        min.ifPresent(x -> System.out.println("Min value intList: " + min.get()));

        System.out.println("------- Task 5 -------");
        Item item;
        int minCostValue = 100;
        int maxCostValue = 200;
        List<Item> items;
        List<Box> boxes = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            box = new Box();
            boxes.add(box);
            box.setSize(getRandomInt(minBoxSize, maxBoxSize));
            items = new LinkedList<>();
            for (int j = 0; j < 10; j++) {
                item = new Item();
                items.add(item);
                item.setCost(getRandomInt(minCostValue, maxCostValue));
                item.setName("Item" + item.getCost());
            }
            box.setItems(items);
        }
        Stream<Box> boxStream = boxes.stream();
        boxStream.forEach(System.out::println);
        boxStream = boxes.stream();
        boxStream.filter(box -> randomFilterSize())
                .flatMap(box -> box.getItems()
                        .stream()
                        .map(Item::getCost))
                .sorted()
                .forEach(System.out::println);
    }

    static int getRandomInt(int minBound, int maxBound) {
        return random.nextInt(maxBound - minBound + 1) + minBound;
    }

    static boolean randomFilterSize() {
        int boxSize = box.getSize();
        int filterMinBound = getRandomInt(minBoxSize, maxBoxSize - 1);
        int filterMaxBound = getRandomInt(filterMinBound, maxBoxSize);
        return boxSize >= filterMinBound && boxSize <= filterMaxBound;
    }
}
