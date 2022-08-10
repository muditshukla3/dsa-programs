package com.ms.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumSubArraySumTest {

    @Test
    public void test1(){
        int[] input = new int[]{1, 4, 2, 6, -8, -3, 20, -2, 5};
        Assertions.assertEquals(23, MaximumSubArraySum.maximumSubArraySum(input));
    }

    @Test
    public void tes2(){
        int[] input = new int[]{5,-13,8,0,16,-2};
        Assertions.assertEquals(24, MaximumSubArraySum.maximumSubArraySum(input));
    }

    @Test
    public void test3(){
        int[] input = new int[]{1,2,3,-1,-3,2,5};
        Assertions.assertEquals(7, MaximumSubArraySum.maximumSubArraySum(input));
    }

    @Test
    public void test4(){
        int[] input = new int[]{4,3,-2,6,-12,7,-1,6};
        Assertions.assertEquals(12, MaximumSubArraySum.maximumSubArraySum(input));
    }

    @Test
    public void test5(){
        int[] input = new int[]{5,4,-1,7,8};
        Assertions.assertEquals(23, MaximumSubArraySum.maximumSubArraySum(input));
    }

    @Test
    public void test6(){
        int[] input = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        Assertions.assertEquals(6, MaximumSubArraySum.maximumSubArraySum(input));
    }
}
