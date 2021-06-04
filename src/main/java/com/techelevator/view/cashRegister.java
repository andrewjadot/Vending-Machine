package com.techelevator.view;

import java.io.*;
import java.sql.Time;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.text.SimpleDateFormat;


public class cashRegister {
    Scanner in = new Scanner(System.in);
    FileWriter auditFile;
    PrintWriter writer;
    public String[] options = {"1) Feed Money", "2) Select Product", "3) Finish Transaction"};
    public Map<String, Products> items;
    public int balance = 0;
    public String inputString;
    public int selectionNum = -1;
    public int selection;
    public Inventory inventory;
    public Products choice;
    public SimpleDateFormat currentTimeFormatter;
    public SimpleDateFormat currentDateFormatter;



    public cashRegister(Inventory inventory) {
        this.inventory = inventory;
        this.balance = balance;
        this.selection = -1;
    }

    public void writeToFile(String action, int amount) {
        Date now = new Date();
        try {
            FileWriter auditFile = new FileWriter("VendingMachineAudit.txt", true);
            PrintWriter writer = new PrintWriter(auditFile);

            currentTimeFormatter = new SimpleDateFormat("HH:mm:ss");
            currentDateFormatter = new SimpleDateFormat("dd-MM-yyy");
            writer.println(currentDateFormatter.format(now) + " | " + currentTimeFormatter.format(now) + " | " + action + " | " + amount + " | " + this.balance);
            writer.close();
        } catch (Exception ignored) {
        }
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

        System.out.println("\nInvalid Input: " + inputString + "\n");
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
                this.finishTransaction();
                return;

            default:
                this.optionsFunction();
        }
    }

    public void makeSale() {
        System.out.println("");
        System.out.println("Make your choice(based on the items code): ");
        inputString = in.nextLine();
        Products choice = this.inventory.makeSale(inputString);
        if (choice.getPrice() <= this.balance) {
            if (choice.stillAvailable() != "Sold Out!") {
                this.balance -= choice.getPrice();
                System.out.println("Price: $" + choice.getPrice() + ".00  | Your remaining Balance: $" + this.balance + ".00");
                System.out.println("\nEnjoy your " + choice.getName() + "! \n" + choice.makeSound() + "\n");
                choice.purchasedItems();
                this.writeToFile(choice.getName() + " " + inputString, choice.getPrice());
            } else {
                System.out.println("That item is sold out!\nPlease try another selection.\n");
            }
        } else {
            System.out.println("Need more money!");
        }

        this.optionsFunction();
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
        this.printBalance();
        this.writeToFile("Fed Money",this.selection);
    }

    public void finishTransaction() {
        System.out.println("Transaction Complete. \nPlease take your change: $" + this.balance + ".00\n\n");
        this.writeToFile("GIVE CHANGE", this.balance);
        this.balance = 0;
    }


    public void optionsFunction() {
        this.displayOptions();
        this.getOptionsSelected();
        this.processSelection();
    }

    public void printBalance() {
        System.out.println("\nYour balance: $" + this.balance + ".00");
    }

    public void writeToFile(String Action) {
        writer.println();
    }


    public static void main(String[] arg) throws IOException {

    }
}