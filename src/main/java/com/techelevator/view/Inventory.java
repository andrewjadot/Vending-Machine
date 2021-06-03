package com.techelevator.view;

public class Inventory {
    public static Products[] items =
    public static String[]
    public Inventory(String[] items) {
        this.items = items;
    }

    public void displayItems() {
        for (int i = 0; i < this.items.length; i++) {
            System.out.println(this.items[i]);
        }
        System.out.println("\nWhat would you like?: ");
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory(items);
        inventory.displayItems();
    }







}