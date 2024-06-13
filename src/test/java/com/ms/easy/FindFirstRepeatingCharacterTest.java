package com.ms.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FindFirstRepeatingCharacterTest {

    @ParameterizedTest
    @CsvSource(value = {"geeksforgeeks:g", "madam:m", "java:a"}, delimiter = ':')
    void shouldFindOutFirstNonRepeatingCharacter(String input, Character expected){
        Character actual = FindFirstRepeatingCharacter.findFirstRepeatingCharacter(input);
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowRuntimeException(){
        Exception exception = assertThrows(RuntimeException.class,
                                            () -> FindFirstRepeatingCharacter.findFirstRepeatingCharacter("james"));
    }
}
