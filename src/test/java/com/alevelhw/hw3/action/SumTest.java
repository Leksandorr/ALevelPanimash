package com.alevelhw.hw3.action;

import com.alevelhw.hw3.model.Numbers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class SumTest {
    private Sum sum;
    private Numbers numbersMock;

    @Before
    public void setUp() {
        sum = new Sum();
        numbersMock = Mockito.mock(Numbers.class);
    }

    @Test
    public void doAction_whenSumPositiveNumbers() {
        Mockito.when(numbersMock.getNumberFirst()).thenReturn(3.0);
        Mockito.when(numbersMock.getNumberSecond()).thenReturn(2.0);
        final double expected = 5.0;
        final double actual = sum.doAction(3.0, 2.0);

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenSumZeroNumbers() {
        Mockito.when(numbersMock.getNumberFirst()).thenReturn(0.0);
        Mockito.when(numbersMock.getNumberSecond()).thenReturn(0.0);
        final double expected = 0.0;
        final double actual = sum.doAction(0.0, 0.0);

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenSumNegativeNumbers() {
        Mockito.when(numbersMock.getNumberFirst()).thenReturn(-3.0);
        Mockito.when(numbersMock.getNumberSecond()).thenReturn(-2.0);
        final double expected = -5.0;
        final double actual = sum.doAction(-3.0, -2.0);

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenSumPositiveNumbersFractional() {
        Mockito.when(numbersMock.getNumberFirst()).thenReturn(3.3);
        Mockito.when(numbersMock.getNumberSecond()).thenReturn(2.2);
        final double expected = 5.5;
        final double actual = sum.doAction(3.3, 2.2);

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenSumNegativeNumbersFractional() {
        Mockito.when(numbersMock.getNumberFirst()).thenReturn(-3.3);
        Mockito.when(numbersMock.getNumberSecond()).thenReturn(-2.2);
        final double expected = -5.5;
        final double actual = sum.doAction(-3.3, -2.2);

        Assert.assertEquals(expected, actual, .0000001);
    }
}