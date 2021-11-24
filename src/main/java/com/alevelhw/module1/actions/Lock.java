package com.alevelhw.module1.actions;

import java.util.Arrays;

public class Lock {
    final private int[] lockArray;

    public Lock(int[] lockArray) {
        this.lockArray = lockArray;
    }

    public int[] getArray() {
        return Arrays.copyOf(lockArray, lockArray.length);
    }
}