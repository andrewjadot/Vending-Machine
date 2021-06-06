package com.techelevator.view;

import java.io.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.text.SimpleDateFormat;


public class cashRegister {
    Scanner in = new Scanner(System.in);
    private FileWriter auditFile;
    private PrintWriter writer;
    private String[] options = {"\n1) Feed Money", "2) Select Product", "3) Finish Transaction"};
    private Map<String, Products> items;
    private int balance = 0;
    private String inputString;
    private int selectionNum;
    private int selection;
    protected Inventory inventory;
    private Products choice;
    private SimpleDateFormat currentTimeFormatter;
    private SimpleDateFormat currentDateFormatter;

    // Cash register constructor
    public cashRegister(Inventory inventory) {
        this.inventory = inventory;
        this.balance = balance;
        this.selection = -1;
    }
    // Method that takes an action string and dollar amount and prints it to audit file
    public void writeToFile(String action, int amount) {
        Date now = new Date();
        try {
            FileWriter auditFile = new FileWriter("VendingMachineAudit.txt", true);
            PrintWriter writer = new PrintWriter(auditFile);

            currentTimeFormatter = new SimpleDateFormat("HH:mm:ss");
            currentDateFormatter = new SimpleDateFormat("dd-MM-yyy");
            writer.println(currentDateFormatter.format(now) + " | " + currentTimeFormatter.format(now) + " | " + action + " | $" + amount + ".00 | $" + this.balance + ".00 ");
            writer.close();

        } catch (Exception ignored) {
        }
    }
    // Method to display the cash register options
    public void displayOptions() {
        for (int i = 0; i < this.options.length; i++) {

            System.out.println(this.options[i]);

        }
        System.out.println("\nRemaining Balance: $" + this.balance + ".00");
        System.out.print("\nPlease select an option: ");
    }
    // Method takes user input and converts it to a string and returns selection number as well
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

        System.out.println("\nInvalid Input: " + inputString + "\n");
        return selectionNum;
    }
    // Switch for cash register options
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
                this.finishTransaction();
                return;
            default:
                this.optionsFunction();
        }
    }
    // Checks validity of user input and returns them to the cash register options also displaying the balance
    public void makeSale() {
        System.out.println("");
        System.out.println("Make your choice(based on the items code): ");
        inputString = in.nextLine();
        Products choice = this.inventory.makeSale(inputString);
        if(choice == null){
            System.out.println("Invalid code: " + inputString);
            System.out.println("You are being returned to the purchase menu!");
            this.optionsFunction();
        }
        if (choice.getPrice() <= this.balance) {
            if (choice.stillAvailable() != "Sold Out!") {
                this.balance -= choice.getPrice();
                System.out.println("\nPrice: $" + choice.getPrice() + ".00  | Your remaining Balance: $" + this.balance + ".00");
                System.out.println("\nEnjoy your " + choice.getName() + "! \n" + choice.makeSound() + "\n");
                choice.purchasedItems();
                this.writeToFile(choice.getName() + " " + inputString, choice.getPrice());
            } else {
                System.out.println("That item is sold out!\nPlease try another selection.\n");
            }
        } else {
            System.out.println("Need more money!" + "\n");
        }
        this.optionsFunction();
    }
    // Method for feeding money to vending machine
    public void feedMoney() {
        System.out.print("\nPlease add either $1, $2, $5, $10 (as an integer): ");
        try {
            inputString = in.nextLine();
            selectionNum = Integer.parseInt(inputString);
            this.selection = selectionNum;

        } catch (NumberFormatException e) {

        }
        switch (this.selection) {
            case 1:
                this.balance += 1;
                break;
            case 2:
                this.balance += 2;
                break;
            case 5:
                this.balance += 5;
                break;
            case 10:
                this.balance += 10;
                break;
            default:
                System.out.println("Invalid input please enter Integer");
                this.feedMoney();
        }
        this.writeToFile("Fed Money", this.selection);
    }
    // Method for finishing transaction and giving back change as well as updating balance upon ending the transaction
    public void finishTransaction() {
        System.out.println("\nTransaction Complete. \nPlease take your change: $" + this.balance + ".00\n");
        this.writeToFile("GIVE CHANGE", this.balance);
        this.balance = 0;
    }
    // Helper method for the cash register options
    public void optionsFunction() {
        this.displayOptions();
        this.getOptionsSelected();
        this.processSelection();
    }
}