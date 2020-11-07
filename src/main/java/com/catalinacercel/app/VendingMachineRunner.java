package com.catalinacercel.app;

import com.catalinacercel.service.VendingMachineImpl;

public class VendingMachineRunner {
    public static void main(String[] args) {
        VendingMachineImpl vendingMachine = new VendingMachineImpl();
        vendingMachine.run();
    }
}
