package com.techelevator.view;

public class Candy extends Products{
    public Candy(String slot, String name, int price, int stock) {
        super(slot, name, price, stock);
    }

    //Abstract Method implementation override
    @Override
    public String makeSound() {
        return "Munch, Munch, Yum!";
    }
}
