package com.techelevator.view;

import java.util.Scanner;

public class CashRegister {
    Scanner in = new Scanner(System.in);
    public String[] money;
    public String[] options = {"1) Feed Money", "2) Select Product", "3) Finish Transaction"};
    public static String[] items = {"1) Chips", "2) Drinks", "3) Gum", "4) Candy"};
    public int balance = 0;
    public String inputString;
    public int selectionNum = -1;
    public int selection;


    public CashRegister(String[] money) {
        this.money = money;
        this.balance = balance;
        this.selection = -1;
    }

    public void displayOptions() {
        for (int i = 0; i < this.options.length; i++) {

            System.out.println(this.options[i]);

        }


        System.out.println("\nCurrent money provided: $" + this.balance + ".00");

    }

    public int getOptionsSelected() {
        try {
            inputString = in.nextLine();
            selectionNum = Integer.parseInt(inputString);

            if (selectionNum > 0 && selectionNum <= this.options.length) {
                this.selection = selectionNum;
                return selectionNum;
            }
        } catch (NumberFormatException e) {
        }

        System.out.println("\nInvalid Input: " + inputString);
        return selectionNum;
    }

    public void processSelection() {
        switch (this.selection) {
            case 1:
                this.feedMoney();
                this.optionsFunction();
                return;
            case 2:
                this.makeSale();
                return;
            case 3:
                System.exit(0);

            default:
                return;
        }
    }


    public void makeSale() {

    }

    public void feedMoney() {
        this.selection = -1;
        System.out.println("Please add either $1, $2, $5, $10");
        try {
            inputString = in.nextLine();
            selectionNum = Integer.parseInt(inputString);
            this.selection = selectionNum;
        } catch (NumberFormatException e) {

        }
        switch (this.selection) {
            case 1:
                balance += 1;
                System.out.println("\nCurrent money provided: $" + this.balance + ".00");
                this.displayOptions();
                return;
            case 2:
                balance += 2;
                System.out.println("\nCurrent money provided: $" + this.balance + ".00");
                this.displayOptions();
                return;
            case 5:
                balance += 5;
                System.out.println("\nCurrent money provided: $" + this.balance + ".00");
                this.displayOptions();
                return;
            case 10:
                balance += 10;
                System.out.println("\nCurrent money provided: $" + this.balance + ".00");
                this.displayOptions();
                return;

            default:
                System.out.println("Invalid input please enter Integer");
                this.feedMoney();
        }

    }

    public void displayItems() {
        for (int i = 0; i < this.items.length; i++) {

            System.out.println(this.items[i]);

        }
        System.out.println("\nWhat would you like?: ");
    }

    public void optionsFunction() {
        this.displayOptions();
        this.getOptionsSelected();
        this.processSelection();
    }

    public static void main(String[] arg) {

    }
}
