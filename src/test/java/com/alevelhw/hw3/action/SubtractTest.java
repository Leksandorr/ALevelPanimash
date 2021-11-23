package com.alevelhw.hw3.action;

import com.alevelhw.hw3.model.Numbers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class SubtractTest {
    private Subtract subtract;
    private Numbers numbersMock;

    @Before
    public void setUp() {
        subtract = new Subtract();
        numbersMock = Mockito.mock(Numbers.class);
    }

    @Test
    public void doAction_whenSubtractPositiveNumbers() {
        Mockito.when(numbersMock.getNumberFirst()).thenReturn(5.0);
        Mockito.when(numbersMock.getNumberSecond()).thenReturn(3.0);
        final double expected = 2.0;
        final double actual = subtract.doAction(5.0, 3.0);

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenSubtractZeroNumbers() {
        Mockito.when(numbersMock.getNumberFirst()).thenReturn(0.0);
        Mockito.when(numbersMock.getNumberSecond()).thenReturn(0.0);
        final double expected = 0.0;
        final double actual = subtract.doAction(0.0, 0.0);

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenSubtractNegativeNumbers() {
        Mockito.when(numbersMock.getNumberFirst()).thenReturn(-2.0);
        Mockito.when(numbersMock.getNumberSecond()).thenReturn(-3.0);
        final double expected = 1.0;
        final double actual = subtract.doAction(-2.0, -3.0);

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenSubtractPositiveNumbersFractional() {
        Mockito.when(numbersMock.getNumberFirst()).thenReturn(5.5);
        Mockito.when(numbersMock.getNumberSecond()).thenReturn(3.5);
        final double expected = 2.0;
        final double actual = subtract.doAction(5.5, 3.5);

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenSubtractNegativeNumbersFractional() {
        Mockito.when(numbersMock.getNumberFirst()).thenReturn(-2.5);
        Mockito.when(numbersMock.getNumberSecond()).thenReturn(-3.5);
        final double expected = 1.0;
        final double actual = subtract.doAction(-2.5, -3.5);

        Assert.assertEquals(expected, actual, .0000001);
    }
}