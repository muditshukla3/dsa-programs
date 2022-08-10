package com.ms.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void twoSumTest1() {
        int[] input = new int[]{2,7,11,15};
        int target = 9;
        int[] result = new TwoSum().twoSum(input, target);
        Assertions.assertEquals(0, result[0]);
        Assertions.assertEquals(1, result[1]);
    }

    @Test
    void twoSumTest2() {
        int[] input = new int[]{3,2,4};
        int target = 6;
        int[] result = new TwoSum().twoSum(input, target);
        Assertions.assertEquals(1, result[0]);
        Assertions.assertEquals(2, result[1]);
    }

    @Test
    void twoSumTest3() {
        int[] input = new int[]{3,3};
        int target = 6;
        int[] result = new TwoSum().twoSum(input, target);
        Assertions.assertEquals(0, result[0]);
        Assertions.assertEquals(1, result[1]);
    }
}