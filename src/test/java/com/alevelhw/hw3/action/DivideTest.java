package com.alevelhw.hw3.action;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivideTest {
    private Divide divide;

    @Before
    public void setUp() {
        divide = new Divide();
    }

    @Test
    public void doAction_whenDividePositiveNumbers() {
        divide.setNumberFirst("5");
        divide.setNumberSecond("2");
        final double expected = 2.5;
        final double actual = divide.doAction();

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenDivideZeroFirstNumbers() {
        divide.setNumberFirst("0");
        divide.setNumberSecond("2");
        final double expected = 0.0;
        final double actual = divide.doAction();

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void doAction_whenDivideZeroSecondNumbers() {
        divide.setNumberFirst("2");
        divide.setNumberSecond("0");
        divide.doAction();
    }

    @Test
    public void doAction_whenDivideNegativeNumbers() {
        divide.setNumberFirst("-5");
        divide.setNumberSecond("-2");
        final double expected = 2.5;
        final double actual = divide.doAction();

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenDividePositiveNumbersFractional() {
        divide.setNumberFirst("5.6");
        divide.setNumberSecond("2.5");
        final double expected = 2.24;
        final double actual = divide.doAction();

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenDivideNegativeNumbersFractional() {
        divide.setNumberFirst("-5.6");
        divide.setNumberSecond("-2.5");
        final double expected = 2.24;
        final double actual = divide.doAction();

        Assert.assertEquals(expected, actual, .0000001);
    }
}