package com.ms.easy;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Write a function to find missing number in the range of numbers
 * e.g input[] = new int[]{1, 2, 3, 4, 6, 7, 8, 9, 10}
 */
public class MissingNumber {

    public static int missingNumber(int[] inputArray){
        int missingNumber;
        AtomicInteger sum= new AtomicInteger();
        int len = inputArray.length+1;

        Arrays.stream(inputArray).forEach(number -> sum.addAndGet(number));
        System.out.println(sum.get());
        int seriesSum = (len * (len + 1)) / 2;
        System.out.println(seriesSum);
        return seriesSum-sum.get();
    }
}
