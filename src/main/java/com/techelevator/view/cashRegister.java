package com.techelevator.view;

import java.util.Map;
import java.util.Scanner;

public class cashRegister {
    Scanner in = new Scanner(System.in);
    public String[] options = {"1) Feed Money", "2) Select Product", "3) Finish Transaction"};
    public Map<String, Products> items;
    public int balance = 0;
    public String inputString;
    public int selectionNum = -1;
    public int selection;
    public Inventory inventory;
    public Products choice;

    public cashRegister(Inventory inventory) {
       this.inventory = inventory;
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
        System.out.println("");
        System.out.println("Make your choice(based on the items code): ");
        inputString = in.nextLine();
        Products choice = this.inventory.makeSale(inputString);
        System.out.println(choice);
        if (choice.getPrice() <= this.balance) {
            this.balance -= choice.getPrice();
            System.out.println("Enjoy your " + choice.getName() + "! \n" + choice.makeSound());
            choice.purchasedItems();
        } else {
            System.out.println("Need more money!");
            this.optionsFunction();
        }
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


    public void optionsFunction() {
        this.displayOptions();
        this.getOptionsSelected();
        this.processSelection();
    }

    public static void main(String[] arg) {

    }
}
