package com.techelevator.view;

public abstract class Products {
    private String slot;
    private String name;
    private int price;
    private int stock = 5;

    //Constructor
    public Products(String slot, String name, int price, int stock){
        this.name = slot;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    //Getters
    public String getSlot(){
        return slot;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    //Setters
    public void setSlot(String slot){
        this.slot = slot;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    //Abstract Method
    public abstract String makeSound();



}
