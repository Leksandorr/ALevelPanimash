package com.alevelhw.hw3.action;

import com.alevelhw.hw3.model.Numbers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class MultipleTest {
    private Multiple multiple;
    private Numbers numbersMock;

    @Before
    public void setUp() {
        multiple = new Multiple();
        numbersMock = Mockito.mock(Numbers.class);
    }

    @Test
    public void doAction_whenMultiplePositiveNumbers() {
        Mockito.when(numbersMock.getNumberFirst()).thenReturn(3.0);
        Mockito.when(numbersMock.getNumberSecond()).thenReturn(2.0);
        final double expected = 6.0;
        final double actual = multiple.doAction(3.0, 2.0);

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenMultipleZeroNumbers() {
        Mockito.when(numbersMock.getNumberFirst()).thenReturn(0.0);
        Mockito.when(numbersMock.getNumberSecond()).thenReturn(0.0);
        final double expected = 0.0;
        final double actual = multiple.doAction(0.0, 0.0);

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenMultipleNegativeNumbers() {
        Mockito.when(numbersMock.getNumberFirst()).thenReturn(-3.0);
        Mockito.when(numbersMock.getNumberSecond()).thenReturn(-2.0);
        final double expected = 6.0;
        final double actual = multiple.doAction(-3.0, -2.0);

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenMultiplePositiveNumbersFractional() {
        Mockito.when(numbersMock.getNumberFirst()).thenReturn(5.5);
        Mockito.when(numbersMock.getNumberSecond()).thenReturn(3.5);
        final double expected = 19.25;
        final double actual = multiple.doAction(5.5, 3.5);

        Assert.assertEquals(expected, actual, .0000001);
    }

    @Test
    public void doAction_whenMultipleNegativeNumbersFractional() {
        Mockito.when(numbersMock.getNumberFirst()).thenReturn(-2.5);
        Mockito.when(numbersMock.getNumberSecond()).thenReturn(-3.5);
        final double expected = 8.75;
        final double actual = multiple.doAction(-2.5, -3.5);

        Assert.assertEquals(expected, actual, .0000001);
    }
}