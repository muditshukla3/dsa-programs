package com.ms.easy;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstNonRepeatingCharacter {

    static final int NO_OF_CHARS = 256;
    static char[] count = new char[NO_OF_CHARS];


    public static int findFirstNonRepeatingCharacterIndex(String input){
        getCharCountArray(input);
        return firstNonRepeating(input);
    }

    /* calculate count of characters
       in the passed string */
    static void getCharCountArray(String str)
    {
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)]++;
    }

    /* The method returns index of first non-repeating
       character in a string. If all characters are
       repeating then returns -1 */
    static int firstNonRepeating(String str)
    {
        int index = -1, i;

        for (i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static Character findFirstNonRepetitiveCharacterUsingStreams(String input){
        return  input.chars()           // IntStream
                .mapToObj(i -> Character.toLowerCase((char) i))  // convert to lowercase & then to Character object Stream
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // store in a LinkedHashMap with the count
                .entrySet().stream()                       // EntrySet stream
                .filter(entry -> entry.getValue() == 1L)   // extracts characters with a count of 1
                .map(Map.Entry::getKey)              // get the keys of EntrySet
                .findFirst().orElseThrow(() -> new RuntimeException("No Non Repeating Character"));                     // get the first entry from the keys

    }
}
