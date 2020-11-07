package com.catalinacercel.service;

import com.catalinacercel.constants.Coin;
import com.catalinacercel.constants.Drink;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VendingMachineImpl implements VendingMachineService{

    private int amount;
    private int change;
    private Scanner input;
    private VendingMachineSupplier vendingMachineSupplier;

    public VendingMachineImpl() {
        this.input = new Scanner(System.in);
        this.vendingMachineSupplier = new VendingMachineSupplier();
        vendingMachineSupplier.stackMachine();
    }

    /**
     * This method display the menu of the application
     */
    public void vendorMachineMenu() {

        System.out.println("\nPlease enter your option:");
        System.out.println("Press 1 - COKE   25c" );
        System.out.println("Press 2 - PEPSI  35c");
        System.out.println("Press 3 - SODA   45c");
        System.out.println("Press 9 - Exit");

    }

    /**
     * Banner for the application
     */
    public void infoMessage(){
        System.out.println("=====================================\n" +
                "=     WELCOME TO VENDING MACHINE    =\n" +
                "=   THIS MACHINE ACCEPTS CASH ONLY  =\n" +
                "=====================================");
    }

    /**
     * This method cancel the order
     * @return  the change to the customer
     */
    public int cancel() {
        change = amount;
        amount = 0;
        return change;
    }

    /**
     * The main brain of the application asking for user to input currency and pay for the desired drink
     * @param drink get available drink type
     */
    public void payDrink(String drink) {
        int price = getPrice(drink);
        System.out.println("You have selected " + drink + "\nPrice is : " + price + "c.");

        OUTER:
        while (amount < price) {
            System.out.println("Do you want to insert coins?" +
                    "\n 1- Yes" +
                    "\n 2- Cancel");
            int option = 2;
            try{
                option = input.nextInt();
            } catch (InputMismatchException e){
                System.err.println("Please enter a valid input!");
                System.exit(0);
            }
            switch (option) {
                case 1:
                    System.out.println("Please insert a coin:");
                    int coin = 0;
                    try{
                        coin = input.nextInt();
                    }catch (InputMismatchException e) {
                        System.err.println("Please enter a valid input!");
                        System.exit(0);
                    }
                    if (isValidCoin(coin)) {
                        amount += coin;
                        if(price > amount){
                            System.out.println("Remaining to pay: " + (price - amount));
                        } else if(price == amount){
                            System.out.println("You have purchase: " + drink);
                            break OUTER;
                        } else {
                            System.out.println("You have purchase: " + drink);
                            change = amount - price;
                            System.out.println("Your change was returned: " + change + " c");
                            amount = 0;
                            change = 0;
                            break OUTER;
                        }

                    } else {
                        System.err.println("Invalid coin. Please insert a penny(1), nickle(5), dime(10) or quarter(25).");
                    }
                    break;
                case 2:
                    System.out.println("Transaction was canceled.");
                    int change = cancel();
                    System.out.println("The following amount was returned: " + change);
                    this.amount = 0;
                    this.change = 0;
                    break OUTER;
                default:
                    System.err.println("Invalid Menu Entry. Please pick a number from Menu");
                    break;
            }

        }

    }

    /**
     * Cheks if coin is the desired type. Check Coin enum
     * @param coin denomination
     * @return if it's the right denomination
     */
    public boolean isValidCoin(int coin) {
        if (coin == Coin.PENNY.getDenomination() || coin == Coin.NICKLE.getDenomination() ||
                coin == Coin.DIME.getDenomination() || coin == Coin.QUARTER.getDenomination()) {
            return true;
        }
        return false;
    }

    /**
     * get the price for the desired drink
     * @param drink get available drink type
     * @return price for the drink from Drink enum
     */
    public int getPrice(String drink) {
        return Drink.valueOf(drink).getValue();
    }

    /**
     * Application runner
     */
    public void run() {
        infoMessage();
        boolean exit = true;
        do {
            vendorMachineMenu();
            int option = 0;
            try{
                option = input.nextInt();
            } catch (InputMismatchException e){
                System.err.println("Please enter a valid input!");
                System.exit(0);
            }
            int quantity = 0;
            switch (option) {
                case 1:
                    quantity = vendingMachineSupplier.getDrinkQuantity("Coke");
                    if(quantity > 0){
                        payDrink("COKE");
                    } else {
                        System.err.println("Sorry. COKE is out of stock!");
                    }
                    vendingMachineSupplier.removeDrink("Coke");
                    break;
                case 2:
                    quantity = vendingMachineSupplier.getDrinkQuantity("Pepsi");
                    if(quantity > 0){
                        payDrink("PEPSI");
                    } else {
                        System.err.println("Sorry. PEPSI is out of stock!");
                    }
                    vendingMachineSupplier.removeDrink("Pepsi");
                    break;
                case 3:
                    quantity = vendingMachineSupplier.getDrinkQuantity("Soda");
                    if(quantity > 0){
                        payDrink("SODA");
                    } else {
                        System.err.println("Sorry. SODA is out of stock!");
                    }
                    vendingMachineSupplier.removeDrink("Soda");
                    break;
                case 9:
                    System.out.println("Have a great day. Thanks for shopping!");
                    exit = false;
                    break;
                default:
                    System.err.println("Invalid Menu Entry. Please pick a number from Menu");
                    break;
            }

        } while (exit);
    }

}
