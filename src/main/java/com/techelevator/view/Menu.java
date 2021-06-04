package com.techelevator.view;

import java.util.*;

public class Menu {
    Scanner in = new Scanner(System.in);

    public static String[] menuItems = {"1) Inventory", "2) Purchase", "3) Exit"};
   public static Map<String, Products> items; //String is equal to the position and Products are Chips, Candy, etc.
    //public static String[] items = {"1) Chips", "2) Drinks", "3) Gum", "4) Candy"};
    public static String[] money = {"$1", "$2", "$5", "$10",};
    public int selectionNum;
    public String inputString;
    public int selection;
    public Inventory inventory;
    public CashRegister cashregister;



    public Menu(String[] menuItems, Inventory inventory, CashRegister cashRegister) {
        this.menuItems = menuItems;
        this.inventory = inventory;
        this.selection = -1;
        this.cashregister = cashRegister;
    }

    public void makeMenu() {

        for (int i = 0; i < this.menuItems.length; i++) {
            System.out.println(this.menuItems[i]);
        }



        System.out.println("\nEnter your selection number: ");


    }

    public int getUserSelection() {

        try {
            inputString = in.nextLine();
            selectionNum = Integer.parseInt(inputString);

            if (selectionNum > 0 && selectionNum <= this.menuItems.length) {
                this.selection = selectionNum;

                return selectionNum;
            }
        } catch (NumberFormatException e) {
        }

        System.out.println(this.selection);
        System.out.println("\nInvalid Input: " + inputString);

        return selectionNum;
    }

    public void processSelection() {

        switch (this.selection) {
            case 1:
                this.inventory.displayItems();
               // System.out.println("");
                //this.makeMenu();
                return;
            case 2:
                this.cashregister.optionsFunction();
                return;
            case 3:
                System.exit(0);

            default:
                return;
        }
    }

    public static void main(String[] args) {
<<<<<<< HEAD
        System.out.println("*****************************");
        System.out.println("****WELCOME TO VENDO-TRON****");
        System.out.println("*****************************");
        Inventory inventory = new Inventory(items);
=======
        Inventory inventory = new Inventory();
>>>>>>> 8c2a9e1ef66e4c113d6b7a4f5375ef4dad6e06b0
        CashRegister cashRegister = new CashRegister(money);
        Menu myMenu = new Menu(menuItems, inventory, cashRegister);
        myMenu.makeMenu();
        myMenu.getUserSelection();
        myMenu.processSelection();
    }


}