package com.ms.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConsecutiveSequenceTest {

    @Test
    public void test1(){
        int[] inputArray = {100, 4, 200, 3, 2, 1};
        Assertions.assertEquals(4,
                ConsecutiveSequence.longestConsecutiveSeqLength(inputArray));
    }

    @Test
    public void test2(){
        int[] inputArray = {2, 4, 0, 100, 2, 1};
        Assertions.assertEquals(3,
                ConsecutiveSequence.longestConsecutiveSeqLength(inputArray));
    }

    @Test
    public void test3(){
        int[] inputArray = {100, 4, 200, 3};
        Assertions.assertEquals(2,
                ConsecutiveSequence.longestConsecutiveSeqLength(inputArray));
    }
}
