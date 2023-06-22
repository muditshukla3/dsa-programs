package com.ms.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ReverseIntegerTest {

    @ParameterizedTest
    @CsvSource({"123,321","1,1","54321,12345"})
    public void test(String input, String expected){
        Assertions.assertEquals(Integer.parseInt(expected), new ReverseInteger().reverse(Integer.parseInt(input)));
    }

}
