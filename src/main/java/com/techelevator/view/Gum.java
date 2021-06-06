package com.techelevator.view;

public class Gum extends Products{

    public Gum( String name, int price) {
        super( name, price);
    }

//Abstract Method implementation override
    @Override
    public String makeSound() {
        return "Chew, Chew, Yum!";
    }
}
