package com.alevelhw.hw16;

import com.alevelhw.hw16.action.StudentsActions;
import org.apache.commons.lang3.time.StopWatch;

import java.util.*;

public class Main {
    private static final Random random = new Random();
    private static final StopWatch watch = new StopWatch();

    public static void main(String[] args) {

        List <String> myArrayList = new ArrayList<>();
        List <String> myLinkedList = new LinkedList<>();
        addMillionElements(myArrayList);
        watch.reset();
        List <String> myNewArrayList = getMixedMillionElements(myArrayList);
        System.out.println(myNewArrayList.size());
        watch.reset();

        addMillionElements(myLinkedList);
        watch.reset();
        List <String> myNewList = getMixedMillionElements(myArrayList);
        System.out.println(myNewList.size());
        watch.reset();

//        printMillionElements(myNewArrayList);
//        watch.reset();
//        printMillionElements(myNewList);
//        watch.reset();

        String data = "D       A               Hm\n" +
                " Я просыпаюсь в холодном поту\n" +
                "         Fm#               G\n" +
                " Я просыпаюсь в кошмароном бреду\n" +
                "               Fm#         Em\n" +
                " Как будто дом наш залило водой\n" +
                "                           F#\n" +
                " И что в живых остались только мы с тобой. \n" +
                "Припев:\n" +
                " И что над нами километры воды\n" +
                " И что над нами бьют хвостами киты\n" +
                " И кислорода не хватит на двоих\n" +
                " Я лежу в темноте.\n" +
                " \n" +
                "  Hm            A\n" +
                " Слушая наше дыхание\n" +
                "  Hm             G\n" +
                " Я слушаю наше дыхание\n" +
                "  Hm                    A\n" +
                " Я раньше не думал, что у нас\n" +
                "  Hm                         G\n" +
                " На двоих с тобой одно лишь дихание\n" +
                "  Hm\n" +
                " Дыхание\n" +
                " \n" +
                " И я пытаюсь разучиться дышать,\n" +
                " Чтобы тебе хоть на минуту отдать\n" +
                " Того газа, что не умели ценить,\n" +
                " Но ты спишь и не знаешь \n" +
                "Привев:";
        FrequencyDictionary myDictionary = new FrequencyDictionary(data);
        Set<Map.Entry<String,Integer>> myDictionarySet = myDictionary.getTreeSet();
        System.out.println(myDictionarySet);
        watch.reset();

        String[] testStringArray = new String[]{"Sunday", "Monday", "Saturday", "Friday"};
        ArrayIterator<String> myIterator = new ArrayIterator<>(testStringArray);
        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }

        List<Student> students = new LinkedList<>();
        students.add(new Student("Tom", "2", 3, 4));
        students.add(new Student("Susan", "2", 6, 5));
        students.add(new Student("Jon", "2", 1, 4));
        students.add(new Student("Gregory", "2", 5, 2));
        students.add(new Student("Anna", "2", 4, 4));
        students.add(new Student("Joan", "2", 2, 2));
        StudentsActions studentsActions = new StudentsActions(students);

        System.out.println(students);
        studentsActions.printStudents(students, 1);
        studentsActions.printStudents(students, 2);
        studentsActions.printStudents(students, 3);
        studentsActions.printStudents(students, 4);
        studentsActions.printStudents(students, 5);
        studentsActions.printStudents(students, 6);
        studentsActions.DoActionAfterSession();
        System.out.println(students);
        students.add(new Student("Josh", "2", 1, 5));
        studentsActions.printStudents(students, 1);
        studentsActions.printStudents(students, 2);
        studentsActions.printStudents(students, 3);
        studentsActions.printStudents(students, 4);
        studentsActions.printStudents(students, 5);
        studentsActions.printStudents(students, 6);
        System.out.println(students);
    }

    public static void addMillionElements(List<String> list) {
        watch.start();

        for (int i = 0; i < 1_000_000; i++) {
            list.add(getRandomString());
        }

        watch.stop();
        System.out.println("Time Elapsed for addMillionElements: " + watch.getTime() + " milliseconds");
    }

    public static List<String> getMixedMillionElements(List<String> list) {
        watch.start();

        List <String> myNewArrayList = new ArrayList<>(1_000_000);
        for (int i = 0; i < 1_000_000; i++) {
            int minBound = 0;
            int maxBound = 999_999;
            int randomNumber = random.nextInt(maxBound - minBound + 1) + minBound;
            myNewArrayList.add(list.get(randomNumber));
        }

        watch.stop();
        System.out.println("Time Elapsed for getMixedMillionElements: " + watch.getTime() + " milliseconds");
        return myNewArrayList;
    }

    public static void printMillionElements(List<String> list) {
        watch.start();

        for (int i = 0; i < 1_000_000; i++) {
            int minBound = 0;
            int maxBound = 999_999;
            int randomNumber = random.nextInt(maxBound - minBound + 1) + minBound;
            System.out.println(list.get(randomNumber));
        }

        watch.stop();
        System.out.println("Time Elapsed for printMillionElements: " + watch.getTime() + " milliseconds");
    }

    public static String getRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int minBound = 3;
        int maxBound = 10;
        int targetNameLength = random.nextInt(maxBound - minBound + 1) + minBound;
        StringBuilder builder = new StringBuilder(targetNameLength);
        for (int i = 0; i < targetNameLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            builder.append((char) randomLimitedInt);
        }
        builder.insert(0, builder.
                substring(0, 1).toUpperCase());
        return builder.toString();
    }
}
