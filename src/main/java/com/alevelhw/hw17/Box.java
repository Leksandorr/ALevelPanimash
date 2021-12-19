package com.alevelhw.hw17;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Box {
    private int size;
    private List<Item> items;

    @Override
    public String toString() {
        return "Box{" +
                "size=" + size +
                ", items=" + items +
                '}';
    }
}
