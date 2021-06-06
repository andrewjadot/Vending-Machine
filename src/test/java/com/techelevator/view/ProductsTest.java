package com.techelevator.view;

import org.junit.Assert;

public class ProductsTest {

    public void is_product_still_available() {
        Products stock = new Candy("fiveGum", 1);
        int stocks = 5;

        int result = stocks - 1;

        Assert.assertEquals(4, result);
    }
}



