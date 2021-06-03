package com.techelevator.view;

public class Drinks extends Products{
    public Drinks(String slot, String name, int price, int stock) {
        super(slot, name, price, stock);
    }

    //Abstract Method implementation override
    @Override
    public String makeSound() {
        return "Glug, Glug, Yum!";
    }
}
