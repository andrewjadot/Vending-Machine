package com.techelevator.view;

public class Chips extends Products{
    //Constructor
    public Chips( String name, int price){
        super( name, price);
    }

    //Abstract Method implementation override
    @Override
    public String makeSound(){
        return "Crunch, Crunch, Yum!";
    }
}
