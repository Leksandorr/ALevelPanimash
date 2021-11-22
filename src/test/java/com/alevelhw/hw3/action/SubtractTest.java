package com.alevelhw.hw3.action;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubtractTest {
    private Subtract subtract;

    @Before
    public void setUp() {
        subtract = new Subtract();
    }

    @Test
    public void doAction_whenSubtractPositiveNumbers() {
        subtract.setNumberFirst("5");
        subtract.setNumberSecond("3");
        final double expected = 2.0;
        final double actual = subtract.doAction();

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenSubtractZeroNumbers() {
        subtract.setNumberFirst("0");
        subtract.setNumberSecond("0");
        final double expected = 0.0;
        final double actual = subtract.doAction();

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenSubtractNegativeNumbers() {
        subtract.setNumberFirst("-2");
        subtract.setNumberSecond("-3");
        final double expected = 1.0;
        final double actual = subtract.doAction();

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenSubtractPositiveNumbersFractional() {
        subtract.setNumberFirst("5.5");
        subtract.setNumberSecond("3.5");
        final double expected = 2.0;
        final double actual = subtract.doAction();

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenSubtractNegativeNumbersFractional() {
        subtract.setNumberFirst("-2.5");
        subtract.setNumberSecond("-3.5");
        final double expected = 1.0;
        final double actual = subtract.doAction();

        Assert.assertEquals(expected, actual, .0000001);
    }
}