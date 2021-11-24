package com.alevelhw.hw3.action;

import com.alevelhw.hw3.model.Numbers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class DivideTest {
    private Divide divide;
    private Numbers numbersMock;

    @Before
    public void setUp() {
        divide = new Divide();
        numbersMock = Mockito.mock(Numbers.class);
    }

    @Test
    public void doAction_whenDividePositiveNumbers() {
        Mockito.when(numbersMock.getNumberFirst()).thenReturn(5.0);
        Mockito.when(numbersMock.getNumberSecond()).thenReturn(2.0);
        final double expected = 2.5;
        final double actual = divide.doAction(5.0, 2.0);

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenDivideZeroFirstNumbers() {
        Mockito.when(numbersMock.getNumberFirst()).thenReturn(0.0);
        Mockito.when(numbersMock.getNumberSecond()).thenReturn(2.0);
        final double expected = 0.0;
        final double actual = divide.doAction(0.0, 3.0);

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void doAction_whenDivideZeroSecondNumbers() {
        Mockito.when(numbersMock.getNumberFirst()).thenReturn(3.0);
        Mockito.when(numbersMock.getNumberSecond()).thenReturn(0.0);
        final double actual = divide.doAction(3.0, 0.0);
    }

    @Test
    public void doAction_whenDivideNegativeNumbers() {
        Mockito.when(numbersMock.getNumberFirst()).thenReturn(-5.0);
        Mockito.when(numbersMock.getNumberSecond()).thenReturn(-2.0);
        final double expected = 2.5;
        final double actual = divide.doAction(-5.0, -2.0);

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenDividePositiveNumbersFractional() {
        Mockito.when(numbersMock.getNumberFirst()).thenReturn(5.6);
        Mockito.when(numbersMock.getNumberSecond()).thenReturn(2.5);
        final double expected = 2.24;
        final double actual = divide.doAction(5.6, 2.5);

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenDivideNegativeNumbersFractional() {
        Mockito.when(numbersMock.getNumberFirst()).thenReturn(-5.6);
        Mockito.when(numbersMock.getNumberSecond()).thenReturn(-2.5);
        final double expected = 2.24;
        final double actual = divide.doAction(-5.6, -2.5);

        Assert.assertEquals(expected, actual, .0000001);
    }
}