package com.techelevator.view;

import java.util.HashMap;
import java.util.Map;

public abstract class Products {

    private String name;
    private int price;
    private int stock;



    //Constructor for general product info
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


    //Method to see whether item is in stock or not
    public String stillAvailable(){
        if(this.stock >= 1){
            return "" + this.stock;
        }
        return "Sold Out!";
        }

    // Method to reduce stock by one after every purchase
    public void purchasedItems(){
        this.stock--;
    }

<<<<<<< HEAD

    //Abstract Method for item sound
=======
    //Abstract Method
>>>>>>> 439d68be9be492b5ab84870f5bd3b4bdb2973355
    public abstract String makeSound();

}
