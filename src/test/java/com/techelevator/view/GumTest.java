package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class GumTest {

    @Test
    public void do_we_chew_the_gum(){
        Gum gum = new Gum("FiveGum", 1);

        String result = gum.makeSound();


        Assert.assertEquals("Chew, Chew, Yum!", result);
    }
}
