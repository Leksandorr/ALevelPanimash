package com.alevelhw.hw3.service;

import com.alevelhw.hw3.model.Numbers;
import com.alevelhw.hw3.model.Sign;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class UserActionServiceVar2Test {
    private UserActionServiceVar2 userActionServiceVar2;
    Numbers numbers;

    @Before
    public void setUp() {
        userActionServiceVar2 = new UserActionServiceVar2();
        numbers = Mockito.mock(Numbers.class);
    }

    @Test
    public void calculator_whenPlusAndPositiveNumbers() {
        Sign sign = new Sign('+');
        Mockito.when(numbers.getNumberFirst()).thenReturn(3.0);
        Mockito.when(numbers.getNumberSecond()).thenReturn(2.0);
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(5.0, actual, .0000001);
    }

    @Test
    public void calculator_whenPlusAndFirstNegativeNumber() {
        Mockito.when(numbers.getNumberFirst()).thenReturn(-3.0);
        Mockito.when(numbers.getNumberSecond()).thenReturn(2.0);
        Sign sign = new Sign('+');
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(-1.0, actual, .0000001);
    }

    @Test
    public void calculator_whenPlusAndSecondNegativeNumber() {
        Mockito.when(numbers.getNumberFirst()).thenReturn(3.0);
        Mockito.when(numbers.getNumberSecond()).thenReturn(-2.0);
        Sign sign = new Sign('+');
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(1.0, actual, .0000001);
    }

    @Test
    public void calculator_whenPlusAndZeroNumbers() {
        Mockito.when(numbers.getNumberFirst()).thenReturn(0.0);
        Mockito.when(numbers.getNumberSecond()).thenReturn(0.0);
        Sign sign = new Sign('+');
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(0.0, actual, .0000001);
    }

    @Test
    public void calculator_whenMinusAndPositiveNumbers() {
        Mockito.when(numbers.getNumberFirst()).thenReturn(3.0);
        Mockito.when(numbers.getNumberSecond()).thenReturn(2.0);
        Sign sign = new Sign('-');
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(1.0, actual, .0000001);
    }

    @Test
    public void calculator_whenMinusAndFirstNegativeNumber() {
        Mockito.when(numbers.getNumberFirst()).thenReturn(-3.0);
        Mockito.when(numbers.getNumberSecond()).thenReturn(2.0);
        Sign sign = new Sign('-');
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(-5.0, actual, .0000001);
    }

    @Test
    public void calculator_whenMinusAndSecondNegativeNumber() {
        Mockito.when(numbers.getNumberFirst()).thenReturn(3.0);
        Mockito.when(numbers.getNumberSecond()).thenReturn(-2.0);
        Sign sign = new Sign('-');
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(5.0, actual, .0000001);
    }

    @Test
    public void calculator_whenMinusAndZeroNumbers() {
        Mockito.when(numbers.getNumberFirst()).thenReturn(0.0);
        Mockito.when(numbers.getNumberSecond()).thenReturn(0.0);
        Sign sign = new Sign('-');
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(0.0, actual, .0000001);
    }

    @Test
    public void calculator_whenAsteriskAndPositiveNumbers() {
        Mockito.when(numbers.getNumberFirst()).thenReturn(3.0);
        Mockito.when(numbers.getNumberSecond()).thenReturn(2.0);
        Sign sign = new Sign('*');
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(6.0, actual, .0000001);
    }

    @Test
    public void calculator_whenAsteriskAndFirstNegativeNumber() {
        Mockito.when(numbers.getNumberFirst()).thenReturn(-3.0);
        Mockito.when(numbers.getNumberSecond()).thenReturn(2.0);
        Sign sign = new Sign('*');
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(-6.0, actual, .0000001);
    }

    @Test
    public void calculator_whenAsteriskAndSecondNegativeNumber() {
        Mockito.when(numbers.getNumberFirst()).thenReturn(3.0);
        Mockito.when(numbers.getNumberSecond()).thenReturn(-2.0);
        Sign sign = new Sign('*');
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(-6.0, actual, .0000001);
    }

    @Test
    public void calculator_whenAsteriskAndZeroNumbers() {
        Mockito.when(numbers.getNumberFirst()).thenReturn(0.0);
        Mockito.when(numbers.getNumberSecond()).thenReturn(0.0);
        Sign sign = new Sign('*');
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(0.0, actual, .0000001);
    }

    @Test
    public void calculator_whenSlashAndPositiveNumbers() {
        Mockito.when(numbers.getNumberFirst()).thenReturn(3.0);
        Mockito.when(numbers.getNumberSecond()).thenReturn(2.0);
        Sign sign = new Sign('/');
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(1.5, actual, .0000001);
    }

    @Test
    public void calculator_whenSlashAndFirstNegativeNumber() {
        Mockito.when(numbers.getNumberFirst()).thenReturn(-3.0);
        Mockito.when(numbers.getNumberSecond()).thenReturn(2.0);
        Sign sign = new Sign('/');
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(-1.5, actual, .0000001);
    }

    @Test
    public void calculator_whenSlashAndSecondNegativeNumber() {
        Mockito.when(numbers.getNumberFirst()).thenReturn(3.0);
        Mockito.when(numbers.getNumberSecond()).thenReturn(-2.0);
        Sign sign = new Sign('/');
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(-1.5, actual, .0000001);
    }

    @Test
    public void calculator_whenSlashAndFirstZeroNumbers() {
        Mockito.when(numbers.getNumberFirst()).thenReturn(0.0);
        Mockito.when(numbers.getNumberSecond()).thenReturn(2.0);
        Sign sign = new Sign('/');
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(0.0, actual, .0000001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void calculator_whenSlashAndSecondZeroNumbers() {
        Mockito.when(numbers.getNumberFirst()).thenReturn(3.0);
        Mockito.when(numbers.getNumberSecond()).thenReturn(0.0);
        Sign sign = new Sign('/');
        userActionServiceVar2.userActionOperationService.doAction(sign, numbers);
    }
}