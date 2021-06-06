package com.techelevator.view;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Inventory {
    private static Map<String, Products> items = new LinkedHashMap<String, Products>();
    private Products choice;

    // List of Items
    Gum fiveGum = new Gum("FiveGum", 1);
    Gum bigRed = new Gum("Big Red", 1);
    Gum doubleMint = new Gum("Double Mint", 1);

    Chips laysOriginal = new Chips("Lay's Orginal", 2);
    Chips doritos = new Chips("Dorito's", 2);
    Chips herrs = new Chips("Herr's Kettle-Cooked", 2);

    Candy snickers = new Candy("Snicker's", 3);
    Candy reeses = new Candy("Reese's", 3);
    Candy payday = new Candy("PayDay", 3);

    Drinks mountainDew = new Drinks("Mountain Dew", 4);
    Drinks coke = new Drinks("Coke", 4);
    Drinks sprite = new Drinks("Sprite", 4);

    // Inventory constructor, adds all to map
    public Inventory() {
        this.items = items;


        items.put("A1", fiveGum);
        items.put("A2", bigRed);
        items.put("A3", doubleMint);
        items.put("B1", laysOriginal);
        items.put("B2", doritos);
        items.put("B3", herrs);
        items.put("C1", snickers);
        items.put("C2", reeses);
        items.put("C3", payday);
        items.put("D1", mountainDew);
        items.put("D2", coke);
        items.put("D3", sprite);
    }

    // Method declaration for displaying items
    public void displayItems() {

        if (items != null) {
            for (Map.Entry<String, Products> item : items.entrySet()) {
                System.out.println(item.getKey() + " " + item.getValue().getName() + " $" + item.getValue().getPrice() + ".00  Stock: " + item.getValue().getStock());
            }

        }

    }
    // Method to get product choice based on user input
    // Returns selected product object
    public Products makeSale(String inputString) {

        if (items.containsKey(inputString)) {
            Products choice = items.get(inputString);
            return choice;
        }
        return choice;
    }

}