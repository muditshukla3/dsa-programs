package com.ms.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MissingNumberTest {

    @Test
    public void test1(){
        Assertions.assertEquals(5, MissingNumber.missingNumber(new int[]{1, 2, 3, 4, 6, 7, 8, 9, 10}));
    }
}
