package com.techelevator.view;
import java.util.*;
public class Menu {
    Scanner in = new Scanner(System.in);

    public static String[] menuItems = {"1) Inventory", "2) Purchases", "3) Exit"};
    public static String[] items = {"1) Chips", "2) Drinks", "3) Gum", "4) Candy"};
    public static String[] money = {"$1", "$2", "$5", "$10", };
    public int selectionNum;
    public String inputString;
    public int selection;
    public Inventory inventory;
    public cashRegister cashregister;

    public Menu (String[] menuItems, Inventory inventory, cashRegister cashregister) {
        this.menuItems = menuItems;
        this.inventory = inventory;
        this.selection = -1;
        this.cashregister = cashregister;
    }

    public void makeMenu() {

        for (int i = 0; i < this.menuItems.length; i++) {
            System.out.println(this.menuItems[i]);
        };


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
        } catch (NumberFormatException erik) {}

        System.out.println(this.selection);
        System.out.println("\nInvalid Input: " + inputString);

        return selectionNum;
    }

    public void processSelection() {

        switch(this.selection) {
            case 1:
                this.inventory.displayItems();
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
        Inventory inventory = new Inventory(items);
        cashRegister cashregister = new cashRegister(money);
        Menu myMenu = new Menu(menuItems, inventory, cashregister);
        myMenu.makeMenu();
        myMenu.getUserSelection();
        myMenu.processSelection();
    }




}