package com.ms.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DuplicateCharactersTest {

    @Test
    public void test1(){
        String input = "aabccd";
        Set<Character> expectedCharSet = new HashSet<>();
        expectedCharSet.add('a');
        expectedCharSet.add('c');
        Stream<Character> charStream = input.chars().mapToObj(c -> (char)c);
        Set<Character> result = DuplicateCharacters.findDuplicateStream(charStream);
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(expectedCharSet, result);
    }

    @Test
    public void test2(){
        String input = "abcd";
        Stream<Character> charStream = input.chars().mapToObj(c -> (char)c);
        Set<Character> result = DuplicateCharacters.findDuplicateStream(charStream);
        Assertions.assertEquals(0, result.size());
    }

    @Test
    public void test3(){
        IntStream input = IntStream.of(1,2,34,56,34, 14);
        Set<Integer> expectedIntSet = new HashSet<>();
        expectedIntSet.add(34);
        Set<Integer> result = DuplicateCharacters.findDuplicateStream(input.boxed());
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(expectedIntSet, result);
    }
}
