package com.ms.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseIntegerTest {

    @Test
    public void test1(){
        Assertions.assertEquals(321, new ReverseInteger().reverse(123));
    }

    @Test
    public void test2(){
        Assertions.assertEquals(1, new ReverseInteger().reverse(1));
    }

    @Test
    public void test3(){
        Assertions.assertEquals(12345, new ReverseInteger().reverse(54321));
    }

}
