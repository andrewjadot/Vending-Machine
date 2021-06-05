package com.techelevator.view;

import java.util.*;

public class Menu {
    Scanner in = new Scanner(System.in);
    private static String[] menuItems = {"1) Inventory", "2) Purchase", "3) Exit"};
    private static Map<String, Products> items;
    private int selectionNum;
    private String inputString;
    private int selection;
    private Inventory inventory;
    private cashRegister cashregister;


    public Menu(String[] menuItems, cashRegister cashRegister) {
        this.menuItems = menuItems;
        this.cashregister = cashRegister;
    }

    public void makeMenu() {

        for (int i = 0; i < this.menuItems.length; i++) {
            System.out.println(this.menuItems[i]);
        }
        System.out.print("\nEnter your selection number: ");

    }

    public int getUserSelection() {

        try {
            inputString = in.nextLine();
            selectionNum = Integer.parseInt(inputString);

            if (selectionNum > 0 && selectionNum <= this.menuItems.length) {
                this.selection = selectionNum;

                return 0;
            }
        } catch (NumberFormatException e) {
        }


        System.out.println("\nInvalid Input: " + inputString);

        return selectionNum;
    }

    public void processSelection() {

        switch (this.selection) {
            case 1:
                this.cashregister.inventory.displayItems();
                System.out.println("");
                this.menuFunction();
                return;
            case 2:
                this.cashregister.optionsFunction();
                this.menuFunction();
                return;
            case 3:

                System.out.println("Thank you come again!");
                System.exit(0);

            default:
                menuFunction();
        }
    }

    public void menuFunction() {
        this.makeMenu();
        this.getUserSelection();
        this.processSelection();
    }

    public static void main(String[] args) {
        System.out.println("");
        System.out.println("*****************************");
        System.out.println("****WELCOME TO VENDO-TRON****");
        System.out.println("*****************************");
        System.out.println("");

        Inventory inventory = new Inventory();
        cashRegister cashRegister = new cashRegister(inventory);
        Menu myMenu = new Menu(menuItems, cashRegister);
        myMenu.makeMenu();
        myMenu.getUserSelection();
        myMenu.processSelection();
    }


}