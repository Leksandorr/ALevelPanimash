package com.alevelhw.hw18.model;

import lombok.Setter;

@Setter
public class MaxLiftingCapacity {
    String unit;
    int value;

    @Override
    public String toString() {
        return "MaxLiftingCapacity{" +
                "unit='" + unit + '\'' +
                ", value=" + value +
                '}';
    }
}
