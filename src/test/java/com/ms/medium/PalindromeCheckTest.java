package com.ms.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PalindromeCheckTest {

    @ParameterizedTest
    @ValueSource(strings = {"madam", "icici", "abab", "abbaaaa"})
    public void valid(String input){
        Assertions.assertTrue(PalindromeCheck.canFormPalindrome(input));
    }
    @ParameterizedTest
    @ValueSource(strings = {"geeksforgeeks", "palindrom"})
    public void invalid(String input){
        Assertions.assertFalse(PalindromeCheck.canFormPalindrome(input));
    }
}
