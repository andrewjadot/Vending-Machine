package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class ChipsTest {

    @Test
    public void do_we_crunch_the_chips(){
        Chips chips = new Chips("Lay's Orginal", 2);

        String result = chips.makeSound();


        Assert.assertEquals("Crunch, Crunch, Yum!", result);
    }
}
