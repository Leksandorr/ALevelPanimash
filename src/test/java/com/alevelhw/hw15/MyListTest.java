package com.alevelhw.hw15;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class MyListTest {
    MyList<String> myList;
    MyList<Integer> myListInteger;

    @Before
    public void setUp() {
        myList = new MyList<>();
    }

    @Test
    public void getFromLast_whenEmptyList() {
        assertNull(myList.getFromLast(null));
    }

    @Test
    public void getFromLast_whenOneString() {
        myList.add("one");
        assertEquals("one", myList.getFromLast("one"));
    }

    @Test
    public void getFromLast_whenTwoStrings() {
        myList.add("one");
        myList.add("two");

        assertEquals("two", myList.getFromLast("two"));
    }

    @Test
    public void getFromLast_whenFourStrings() {
        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.add("four");

        assertEquals("three", myList.getFromLast("three"));
        assertEquals("four", myList.getFromLast("four"));
    }

    @Test
    public void getFromLast_whenFourIntegers() {
        myListInteger = new MyList<>();
        myListInteger.add(1);
        myListInteger.add(2);
        myListInteger.add(3);
        myListInteger.add(55);

        assertEquals(Integer.valueOf(1), myListInteger.getFromLast(1));
        assertEquals(Integer.valueOf(2), myListInteger.getFromLast(2));
        assertEquals(Integer.valueOf(3), myListInteger.getFromLast(3));
        assertEquals(Integer.valueOf(55), myListInteger.getFromLast(55));
    }
}