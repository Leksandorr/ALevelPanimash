package com.alevelhw.hw8;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class MyFirstUnitTestTest {
    private ByteArrayOutputStream output;
    private PrintStream oldOutput;

    @Before
    public void setUpStreams() {
        oldOutput = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(oldOutput);
    }

    @Test
    public void countSumDigitsOfNumber_whenPositiveNumber() {
        MyFirstUnitTest.countSumDigitsOfNumber("258");
        String expected = "15";

        Assert.assertEquals(expected, output.toString());
    }

    @Test
    public void countSumDigitsOfNumber_whenNegativeNumber() {
        MyFirstUnitTest.countSumDigitsOfNumber("-258");
        String expected = "Введите положительное число\n";

        Assert.assertEquals(expected, output.toString());
    }

    @Test
    public void countSumDigitsOfNumber_whenZeroNumber() {
        MyFirstUnitTest.countSumDigitsOfNumber("0");
        String expected = "0";

        Assert.assertEquals(expected, output.toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void countSumDigitsOfNumber_whenNotNumber() {
        MyFirstUnitTest.countSumDigitsOfNumber("test");
    }
}