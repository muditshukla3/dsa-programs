package com.ms.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RansomTextTest {


    @Test
    public void test1(){
        Assertions.assertFalse(RansomText.canRansomTextConstruct("a","b"));
    }

    @Test
    public void test2(){
        Assertions.assertFalse(RansomText.canRansomTextConstruct("aa","ab"));
    }

    @Test
    public void test3(){
        Assertions.assertTrue(RansomText.canRansomTextConstruct("ba","aba"));
    }

    @Test
    public void test4(){
        Assertions.assertTrue(RansomText.canRansomTextConstruct("aaa","aabab"));
    }
}
