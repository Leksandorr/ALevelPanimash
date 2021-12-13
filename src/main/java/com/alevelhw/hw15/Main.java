package com.alevelhw.hw15;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();
        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.add("four");
        System.out.println(myList.getFromLast("one"));
        System.out.println(myList.getFromLast("two"));
        System.out.println(myList.getFromLast("three"));
        System.out.println(myList.getFromLast("four"));
        System.out.println(myList.getFromLast("five"));

        SortedSet<Box> boxSet = new TreeSet<>(new BoxComparator());
        boxSet.add(new Box(25.5));
        boxSet.add(new Box(5.5));
        boxSet.add(new Box(5.5));
        boxSet.add(new Box(2.0));
        boxSet.add(new Box(0.0));
        boxSet.add(new Box(1.5));
        boxSet.add(new Box(55.5));
        for (Box box : boxSet) {
            System.out.println("Volume: " + box.getVolume());
        }

        List <String> list1 = Arrays.asList("Вася", "Таня", "Даздраперма", "Том", "Жучка");
        Map <String, Integer> map = makeMyMap(list1);
        System.out.println("Вася: " + map.get("Вася"));
        System.out.println("Даздраперма: " + map.get("Даздраперма"));
        System.out.println("Количество пар Ключ-Значение в map " + map.size());
    }

    public static Map<String, Integer> makeMyMap(List<String> list) {
        Map<String, Integer> map = new HashMap<>(list.size());
        for (String s : list) {
            map.put(s, s.length());
        }
        return map;
    }
}
