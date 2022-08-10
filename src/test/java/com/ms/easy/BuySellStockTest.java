package com.ms.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuySellStockTest {

    @Test
    public void test1(){
        Assertions.assertEquals(5, new BuySellStock().maxProfit(new int[]{7,1,5,3,6,4}));
    }

    @Test
    public void test2(){
        Assertions.assertEquals(0, new BuySellStock().maxProfit(new int[]{7,6,4,3,2,1}));
    }

}
