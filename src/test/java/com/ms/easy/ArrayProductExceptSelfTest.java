package com.ms.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayProductExceptSelfTest {

    @Test
    void shouldReturnProductExceptSelf(){
        int[] result = ArrayProductExceptSelf.productExceptSelf(new int[]{1,2,3,4});
        assertEquals(24, result[0]);
        assertEquals(12, result[1]);
        assertEquals(8, result[2]);
        assertEquals(6, result[3]);
    }

}