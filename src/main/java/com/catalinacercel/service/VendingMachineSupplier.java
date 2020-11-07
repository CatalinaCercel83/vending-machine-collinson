package com.catalinacercel.service;

import com.catalinacercel.constants.Drink;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineSupplier {

    private Map<String,Integer> drinksStack;

    public VendingMachineSupplier(){
        drinksStack = new HashMap<>();
        drinksStack.put(Drink.COKE.getName(),0);
        drinksStack.put(Drink.PEPSI.getName(),0);
        drinksStack.put(Drink.SODA.getName(),0);
    }

    /**
     * Stacks the vending machine, i choose 10 as a default max capacity.
     */
    public void stackMachine(){
        drinksStack.put(Drink.COKE.getName(),10);
        drinksStack.put(Drink.PEPSI.getName(),10);
        drinksStack.put(Drink.SODA.getName(),10);
    }

    /**
     * Remove a drink from the vending machine
     * @param drink get available drink type
     */
    public void removeDrink(String drink){
        if(getDrinkQuantity(drink) > 0){
            int value = getDrinkQuantity(drink);
            value--;
            drinksStack.put(drink,value);
        }
    }

    /**
     * Return the available quantity for desired drink
     * @param drink get available drink type
     * @return quantity
     */
    public int getDrinkQuantity(String drink){
        return drinksStack.get(drink);
    }

    /**
     * Resets the machine
     */
    public void clearMachine(){
        drinksStack.clear();
    }
}