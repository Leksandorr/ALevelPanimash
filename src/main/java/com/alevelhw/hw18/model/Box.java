package com.alevelhw.hw18.model;

import lombok.Setter;

import java.time.LocalDateTime;

@Setter
public class Box {
    String from;
    String material;
    String color;
    MaxLiftingCapacity maxLiftingCapacity;
    Cargo cargo;
    LocalDateTime deliveryDate;

    public Box(MaxLiftingCapacity maxLiftingCapacity, Cargo cargo) {
        this.maxLiftingCapacity = maxLiftingCapacity;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Box{" +
                "from='" + from + '\'' +
                ", material='" + material + '\'' +
                ", color='" + color + '\'' +
                ", maxLiftingCapacity=" + maxLiftingCapacity +
                ", cargo=" + cargo +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}