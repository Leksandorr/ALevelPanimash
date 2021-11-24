package com.alevelhw.hw6;

public enum Manufacturer {
    MERCEDES("Мерседес"), BMW("БМВ"),
    PORSCHE("Порш"), TOYOTA("Тойота");

    String russianName;

    Manufacturer(String russianName) {
        this.russianName = russianName;
    }

    @Override
    public String toString() {
        return russianName;
    }
}
