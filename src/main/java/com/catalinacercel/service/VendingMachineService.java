package com.catalinacercel.service;

public interface VendingMachineService {

    void vendorMachineMenu();
    void infoMessage();
    int cancel();
    void payDrink(String drink);
    boolean isValidCoin(int coin);
    int getPrice(String drink);
    void run();
}