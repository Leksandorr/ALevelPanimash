package com.alevelhw.hw3.service;

import com.alevelhw.hw3.model.Numbers;
import com.alevelhw.hw3.model.Sign;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class UserActionServiceVar2Test {
    private UserActionServiceVar2 userActionServiceVar2;
    private UserActionOperationService userActionOperationServiceMock;

    @Before
    public void setUp() throws Exception {
        userActionServiceVar2 = new UserActionServiceVar2();
        userActionOperationServiceMock = Mockito.mock(UserActionOperationService.class);
    }

    @Test
    public void calculator_whenPlusAndPositiveNumbers() {
        Numbers numbers = new Numbers("3.0", "2.0");
        Sign sign = new Sign('+');
        Mockito.when(userActionOperationServiceMock.doAction(sign, numbers)).thenReturn(5.0);
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(5.0, actual, .0000001);
    }

    @Test
    public void calculator_whenPlusAndFirstNegativeNumber() {
        Numbers numbers = new Numbers("-3.0", "2.0");
        Sign sign = new Sign('+');
        Mockito.when(userActionOperationServiceMock.doAction(sign, numbers)).thenReturn(-1.0);
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(-1.0, actual, .0000001);
    }

    @Test
    public void calculator_whenPlusAndSecondNegativeNumber() {
        Numbers numbers = new Numbers("3.0", "-2.0");
        Sign sign = new Sign('+');
        Mockito.when(userActionOperationServiceMock.doAction(sign, numbers)).thenReturn(1.0);
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(1.0, actual, .0000001);
    }

    @Test
    public void calculator_whenPlusAndZeroNumbers() {
        Numbers numbers = new Numbers("0.0", "0.0");
        Sign sign = new Sign('+');
        Mockito.when(userActionOperationServiceMock.doAction(sign, numbers)).thenReturn(0.0);
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(0.0, actual, .0000001);
    }

    @Test
    public void calculator_whenMinusAndPositiveNumbers() {
        Numbers numbers = new Numbers("3.0", "2.0");
        Sign sign = new Sign('-');
        Mockito.when(userActionOperationServiceMock.doAction(sign, numbers)).thenReturn(1.0);
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(1.0, actual, .0000001);
    }

    @Test
    public void calculator_whenMinusAndFirstNegativeNumber() {
        Numbers numbers = new Numbers("-3.0", "2.0");
        Sign sign = new Sign('-');
        Mockito.when(userActionOperationServiceMock.doAction(sign, numbers)).thenReturn(-5.0);
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(-5.0, actual, .0000001);
    }

    @Test
    public void calculator_whenMinusAndSecondNegativeNumber() {
        Numbers numbers = new Numbers("3.0", "-2.0");
        Sign sign = new Sign('-');
        Mockito.when(userActionOperationServiceMock.doAction(sign, numbers)).thenReturn(5.0);
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(5.0, actual, .0000001);
    }

    @Test
    public void calculator_whenMinusAndZeroNumbers() {
        Numbers numbers = new Numbers("0.0", "0.0");
        Sign sign = new Sign('-');
        Mockito.when(userActionOperationServiceMock.doAction(sign, numbers)).thenReturn(0.0);
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(0.0, actual, .0000001);
    }

    @Test
    public void calculator_whenAsteriskAndPositiveNumbers() {
        Numbers numbers = new Numbers("3.0", "2.0");
        Sign sign = new Sign('*');
        Mockito.when(userActionOperationServiceMock.doAction(sign, numbers)).thenReturn(6.0);
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(6.0, actual, .0000001);
    }

    @Test
    public void calculator_whenAsteriskAndFirstNegativeNumber() {
        Numbers numbers = new Numbers("-3.0", "2.0");
        Sign sign = new Sign('*');
        Mockito.when(userActionOperationServiceMock.doAction(sign, numbers)).thenReturn(-6.0);
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(-6.0, actual, .0000001);
    }

    @Test
    public void calculator_whenAsteriskAndSecondNegativeNumber() {
        Numbers numbers = new Numbers("3.0", "-2.0");
        Sign sign = new Sign('*');
        Mockito.when(userActionOperationServiceMock.doAction(sign, numbers)).thenReturn(-6.0);
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(-6.0, actual, .0000001);
    }

    @Test
    public void calculator_whenAsteriskAndZeroNumbers() {
        Numbers numbers = new Numbers("0.0", "0.0");
        Sign sign = new Sign('*');
        Mockito.when(userActionOperationServiceMock.doAction(sign, numbers)).thenReturn(0.0);
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(0.0, actual, .0000001);
    }

    @Test
    public void calculator_whenSlashAndPositiveNumbers() {
        Numbers numbers = new Numbers("3.0", "2.0");
        Sign sign = new Sign('/');
        Mockito.when(userActionOperationServiceMock.doAction(sign, numbers)).thenReturn(1.5);
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(1.5, actual, .0000001);
    }

    @Test
    public void calculator_whenSlashAndFirstNegativeNumber() {
        Numbers numbers = new Numbers("-3.0", "2.0");
        Sign sign = new Sign('/');
        Mockito.when(userActionOperationServiceMock.doAction(sign, numbers)).thenReturn(-1.5);
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(-1.5, actual, .0000001);
    }

    @Test
    public void calculator_whenSlashAndSecondNegativeNumber() {
        Numbers numbers = new Numbers("3.0", "-2.0");
        Sign sign = new Sign('/');
        Mockito.when(userActionOperationServiceMock.doAction(sign, numbers)).thenReturn(-1.5);
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(-1.5, actual, .0000001);
    }

    @Test
    public void calculator_whenSlashAndFirstZeroNumbers() {
        Numbers numbers = new Numbers("0.0", "2.0");
        Sign sign = new Sign('/');
        Mockito.when(userActionOperationServiceMock.doAction(sign, numbers)).thenReturn(0.0);
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);

        Assert.assertEquals(0.0, actual, .0000001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void calculator_whenSlashAndSecondZeroNumbers() {
        Numbers numbers = new Numbers("3.0", "0.0");
        Sign sign = new Sign('/');
        final double actual = userActionServiceVar2.userActionOperationService.doAction(sign, numbers);
    }
}