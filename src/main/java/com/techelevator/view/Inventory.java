package com.techelevator.view;

import java.util.Map;

public class Inventory {
  public static Map<String, Products> items;
    //public static String[] items = {"1) Chips", "2) Drinks", "3) Gum", "4) Candy"};


    Gum fiveGum = new Gum("FiveGum", 1);
    Gum bigRed = new Gum("Big Red", 1);
    Gum doubleMint = new Gum("Double Mint", 1);

    Chips laysOriginal = new Chips("Lay's Orginal", 2);
    Chips doritos = new Chips("Dorito's", 2);
    Chips herrs = new Chips("Herr's Kettle-Cooked", 2);

    Candy snickers = new Candy("Snicker's" , 3);
    Candy reeses = new Candy("Reese's" , 3);
    Candy payday = new Candy("PayDay" , 3);

    Drinks mountainDew = new Drinks ("Mountain Dew", 4);
    Drinks coke = new Drinks ("Coke", 4);
    Drinks sprite = new Drinks ("Sprite", 4);


    public Inventory(Map<String, Products> items) { //change this to a map
        this.items = items;
        items.put("A1", fiveGum);
        items.put("A2", bigRed);
        items.put("A3", doubleMint);
        items.put("B1", laysOriginal);
        items.put("B2", doritos);
        items.put("B3", herrs);
        items.put("C1",snickers);
        items.put("C2", reeses);
        items.put("C3", payday);
        items.put("D1", mountainDew);
        items.put("D2", coke);
        items.put("D3", sprite);
    }




    /*public Inventory(String[] items) {
        this.items = items;
    } */

    public void displayItems() {
        if(items != null)
        for (int i = 0; i < this.items.size(); i++) { //change to this.items.size
            System.out.println(this.items);
        }
       // System.out.println("\nWhat would you like?: ");
    }



    public static void main(String[] args) {
        Inventory inventory = new Inventory(items);
        inventory.displayItems();
    }







}