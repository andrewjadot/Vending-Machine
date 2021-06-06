package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class DrinksTest {

    @Test
    public void do_we_glug_the_drink(){
        Drinks drinks = new Drinks("Mountain Dew", 4);

        String result = drinks.makeSound();


        Assert.assertEquals("Glug, Glug, Yum!", result);
    }
}
