package com.ms.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DisappearedNumbersTest {

    @Test
    void test1(){
        List<Integer> missingNumbers = new DisappearedNumbers().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        Assertions.assertEquals(5, missingNumbers.get(0));
        Assertions.assertEquals(6, missingNumbers.get(1));
    }

    @Test
    void test2(){
        List<Integer> missingNumbers = new DisappearedNumbers().findDisappearedNumbers(new int[]{1,1});
        Assertions.assertEquals(2, missingNumbers.get(0));
    }

    @Test
    void test3(){
        List<Integer> missingNumbers = new DisappearedNumbers().findDisappearedNumbers(new int[]{3, 3, 3, 5, 1});
        Assertions.assertEquals(2, missingNumbers.get(0));
        Assertions.assertEquals(4, missingNumbers.get(1));
    }
}
