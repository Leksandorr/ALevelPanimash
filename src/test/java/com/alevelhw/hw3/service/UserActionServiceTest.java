package com.alevelhw.hw3.service;

import com.alevelhw.hw3.action.Divide;
import com.alevelhw.hw3.action.Multiple;
import com.alevelhw.hw3.action.Subtract;
import com.alevelhw.hw3.action.Sum;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class UserActionServiceTest {

    @Test
    public void calculator_whenCallingSum() {
        Sum sumMock = Mockito.mock(Sum.class);
        Sum sum = new Sum("2","3");
        Mockito.when(sumMock.doAction()).thenReturn(5.0);
        final double actual = sum.doAction();

        Assert.assertEquals(5.0, actual, .0000001);
    }

    @Test
    public void calculator_whenCallingSubtract() {
        Subtract subtractMock = Mockito.mock(Subtract.class);
        Subtract subtract = new Subtract();
        Mockito.when(subtractMock.doAction()).thenReturn(2.0);
        subtract.setNumberFirst("5");
        subtract.setNumberSecond("3");
        final double actual = subtract.doAction();

        Assert.assertEquals(2.0, actual, .0000001);
    }

    @Test
    public void calculator_whenCallingMultiple() {
        Multiple multipleMock = Mockito.mock(Multiple.class);
        Multiple multiple = new Multiple();
        Mockito.when(multipleMock.doAction()).thenReturn(15.0);
        multiple.setNumberFirst("5");
        multiple.setNumberSecond("3");
        final double actual = multiple.doAction();

        Assert.assertEquals(15.0, actual, .0000001);
    }

    @Test
    public void calculator_whenCallingDivide() {
        Divide divideMock = Mockito.mock(Divide.class);
        Divide divide = new Divide();
        Mockito.when(divideMock.doAction()).thenReturn(2.5);
        divide.setNumberFirst("5");
        divide.setNumberSecond("2");
        final double actual = divide.doAction();

        Assert.assertEquals(2.5, actual, .0000001);
    }
}