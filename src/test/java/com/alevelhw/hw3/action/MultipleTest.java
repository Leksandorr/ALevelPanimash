package com.alevelhw.hw3.action;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MultipleTest {
    private Multiple multiple;

    @Before
    public void setUp() {
        multiple = new Multiple();
    }

    @Test
    public void doAction_whenMultiplePositiveNumbers() {
        multiple.setNumberFirst("5");
        multiple.setNumberSecond("3");
        final double expected = 15.0;
        final double actual = multiple.doAction();

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenMultipleZeroNumbers() {
        multiple.setNumberFirst("0");
        multiple.setNumberSecond("0");
        final double expected = 0.0;
        final double actual = multiple.doAction();

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenMultipleNegativeNumbers() {
        multiple.setNumberFirst("-2");
        multiple.setNumberSecond("-3");
        final double expected = 6.0;
        final double actual = multiple.doAction();

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenMultiplePositiveNumbersFractional() {
        multiple.setNumberFirst("5.5");
        multiple.setNumberSecond("3.5");
        final double expected = 19.25;
        final double actual = multiple.doAction();

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenMultipleNegativeNumbersFractional() {
        multiple.setNumberFirst("-2.5");
        multiple.setNumberSecond("-3.5");
        final double expected = 8.75;
        final double actual = multiple.doAction();

        Assert.assertEquals(expected, actual, .0000001);
    }
}