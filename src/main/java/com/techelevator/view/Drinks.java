package com.techelevator.view;

public class Drinks extends Products{
    public Drinks(String name, int price) {
        super( name, price);
    }

    //Abstract Method implementation override
    @Override
    public String makeSound() {
        return "Glug, Glug, Yum!";
    }
}
