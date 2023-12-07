package com.ms.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidAnagramTest {

    @Test
    void testTrue(){
        Assertions.assertTrue(ValidAnagram.isAnagram("anagaram","garamana"));
    }

    @Test
    void testFalse(){
        Assertions.assertFalse(ValidAnagram.isAnagram("test","abc"));
    }
}
