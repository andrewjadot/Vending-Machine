package com.techelevator.view;

public class Chips extends Products{
    //Constructor
    public Chips(String slot, String name, int price, int stock){
        super(slot, name, price, stock);
    }

    //Abstract Method implementation override
    @Override
    public String makeSound(){
        return "Crunch, Crunch, Yum!";
    }
}
