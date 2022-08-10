package com.ms.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromCheckTest {

    @Test
    public void test1(){
        Assertions.assertTrue(PalindromCheck.canFormPalindrom("madam"));
    }
    @Test
    public void test2(){
        Assertions.assertFalse(PalindromCheck.canFormPalindrom("geeksforgeeks"));
    }
    @Test
    public void test3(){
        Assertions.assertTrue(PalindromCheck.canFormPalindrom("icici"));
    }
    @Test
    public void test4(){
        Assertions.assertTrue(PalindromCheck.canFormPalindrom("abab"));
    }
    @Test
    public void test5(){
        Assertions.assertTrue(PalindromCheck.canFormPalindrom("abbaaaa"));
    }
}
