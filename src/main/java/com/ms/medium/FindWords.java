package com.ms.medium;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  examples
 *  findWord(["P>E","E>R","R>U"]) // PERU
 * findWord(["I>N","A>I","P>A","S>P"]) // SPAIN
 * // solve using linked list
 */
public class FindWords {

    static List<String> words = new LinkedList<>();
    private static String findWord(String[] inputArray) {
        StringBuilder result = new StringBuilder();

        // Create a map to store relationships between characters
        java.util.Map<Character, Character> map = new java.util.HashMap<>();

        // Iterate through the array and populate the map
        for (String element : inputArray) {
            char from = element.charAt(0);
            char to = element.charAt(2);
            map.put(from, to);
        }

        // Find the starting point (a character that does not appear in the second position)
        char start = 0;
        for (String element : inputArray) {
            char to = element.charAt(2);
            if (!map.containsValue(to)) {
                start = to;
                break;
            }
        }

        // Follow the relationships to build the result
        char current = start;
        while (map.containsKey(current)) {
            result.append(current);
            current = map.get(current);
        }

        // Append the last character
        result.append(current);
        return result.toString();
    }
    public static void main(String[] args) {
        String[] inputArray1 = new String[]{"I>N", "A>I", "P>A", "S>P"};
        String[] inputArray2 = new String[]{"P>E", "E>R", "R>U"};

        // Find the words
        String word1 = findWord(inputArray1);
        String word2 = findWord(inputArray2);

        // Print the results
        System.out.println("The word for inputArray1 is: " + word1);
        System.out.println("The word for inputArray2 is: " + word2);
    }

    // P E
    // E R
    // R U

    // SPAIN
    // I N
    // P A
    // A I
    // S P

}
