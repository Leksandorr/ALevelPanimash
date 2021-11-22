package com.alevelhw.hw3.action;

import org.junit.Assert;
import org.junit.Test;

public class SumTest {
    private Sum sum;

    @Test
    public void doAction_whenSumPositiveNumbers() {
        sum = new Sum("2", "3");
        final double expected = 5.0;
        final double actual = sum.doAction();

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenSumZeroNumbers() {
        sum = new Sum("0", "0");
        final double expected = 0.0;
        final double actual = sum.doAction();

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenSumNegativeNumbers() {
        sum = new Sum("-2", "-3");
        final double expected = -5.0;
        final double actual = sum.doAction();

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenSumPositiveNumbersFractional() {
        sum = new Sum("2.5", "3.3");
        final double expected = 5.8;
        final double actual = sum.doAction();

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenSumNegativeNumbersFractional() {
        sum = new Sum("-2.3", "-3.5");
        final double expected = -5.8;
        final double actual = sum.doAction();

        Assert.assertEquals(expected, actual, .0000001);
    }
}