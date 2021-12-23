package com.alevelhw.hw18.model;

import lombok.Setter;

@Setter
public class Cargo {
    String name;
    String clas;

    @Override
    public String toString() {
        return "Cargo{" +
                "name='" + name + '\'' +
                ", clas='" + clas + '\'' +
                '}';
    }
}
