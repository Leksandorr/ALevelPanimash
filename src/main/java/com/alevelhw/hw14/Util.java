package com.alevelhw.hw14;

import java.util.List;

class Util<V> implements Multiplier <Number> {
    V value;

    public void printHashCode(V e) {
        System.out.println("HashCode: " + e.hashCode());
    }

    public void save(V value) {
        this.value = value;
    }

    public V get() {
        return value;
    }

    @Override
    public Number[] doubleValueIn(Number[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].doubleValue() * array[i].doubleValue();
        }
        return array;
    }

    public void sum(Number one, Number two) { // should work only with numbers
        System.out.println(one.doubleValue() + two.doubleValue());
    }

    public double sumOfArray(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list) {
            s += (double) n;
        }
        return s;
    }

    public void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
}
