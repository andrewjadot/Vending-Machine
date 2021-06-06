package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class CandyTest {
    @Test
    public void do_we_munch_the_candy(){
        Candy candy = new Candy("PayDay", 3);

        String result = candy.makeSound();


        Assert.assertEquals("Munch, Munch, Yum!", result);
    }
}
