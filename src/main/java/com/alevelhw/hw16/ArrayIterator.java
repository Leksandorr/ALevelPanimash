package com.alevelhw.hw16;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<E> implements Iterator<E> {
    private int element;
    private final E[] array;

    ArrayIterator(E[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return element < array.length;
    }

    @Override
    public E next() {
        int i = element;
        if (i >= array.length) {
            throw new NoSuchElementException("No such element");
        }
        element = i + 1;
        return array[i];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Unsupported operation");
    }
}
