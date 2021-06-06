package com.techelevator.view;

import java.util.HashMap;
import java.util.Map;

public abstract class Products {

    private String name;
    private int price;
    private int stock;



    //Constructor
    public Products( String name, int price){

        this.name = name;
        this.price = price;
        this.stock = 5;

    }


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


    //Methods
    public String stillAvailable(){
        if(this.stock >= 1){
            return "" + this.stock;
        }
        return "Sold Out!";
        }


    public void purchasedItems(){
        this.stock--;
    }

    //Abstract Method
    public abstract String makeSound();

}
