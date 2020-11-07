package com.catalinacercel.constants;

public enum Coin {

    PENNY(1), NICKLE(5), DIME(10), QUARTER(25);

    Coin(int denomination) {
        this.denomination = denomination;
    }
    private int denomination;

    public int getDenomination() {
        return denomination;
    }
}
