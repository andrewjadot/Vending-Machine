package com.techelevator.view;

public class Candy extends Products{
    public Candy( String name,int price) {
        super(name, price);
    }

    //Abstract Method implementation override
    @Override
    public String makeSound() {
        return "Munch, Munch, Yum!";
    }
}
