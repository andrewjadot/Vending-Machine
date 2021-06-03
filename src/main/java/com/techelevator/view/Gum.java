package com.techelevator.view;

public class Gum extends Products{

    public Gum(String slot, String name, int price, int stock) {
        super(slot, name, price, stock);
    }

//Abstract Method implementation override
    @Override
    public String makeSound() {
        return "Chew Chew, Yum!";
    }
}
