package com.techelevator.view;

import java.util.HashMap;
import java.util.Map;

public abstract class Products {

    private String name;
    private int price;
    private int stock;
    private Map<String, Products> items = new HashMap<>();


    //Constructor
    public Products( String name, int price){
        Map<String, Products> items = new HashMap<>();
        this.name = name;
        this.price = price;
        this.stock = 5;
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
    //Should we add all of the items to the map?
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

    //Getters
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStock(){
        return stock;
    }

    //Setters
   // public void setName(String name) {
    //    this.name = name;
   // }

  //  public void setPrice(int price) {
     //   this.price = price;
   // }

    //Methods
    public String stillAvailableForPurchase(){
        if(this.stock >= 1){
            return "" + stock;
        }
        return "Sold Out!";
        }


    public void purchasedItems(){
        stock--;
    }

    public void displayProducts() {
        if(items != null)
            for (int i = 0; i < this.items.size(); i++) { //change to this.items.size
                System.out.println(this.items);
            }
        // System.out.println("\nWhat would you like?: ");
    }


    //Abstract Method
    public abstract String makeSound();



}
