package com.catalinacercel.constants;

public enum Drink {

    PEPSI("Pepsi",35),COKE("Coke",25),SODA("Soda",45);

    private String name;
    private int value;

    Drink(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
