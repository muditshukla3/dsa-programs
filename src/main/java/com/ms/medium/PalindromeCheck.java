package com.ms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Check if characters of a given string can be rearranged to form a palindrome
 * Hint- A set of characters can form a palindrome if at most one character
 * occurs an odd number of times and all characters occur an even number of times.
 */
public class PalindromeCheck {

    public static boolean canFormPalindrome(String str){

        List<Character> charList = new ArrayList<>();

        for(char c: str.toCharArray()){

            if(charList.contains(c)){
                charList.remove((Character) c);
            }else{
                charList.add(c);
            }
        }

        if (str.length() % 2 == 0
                && charList.isEmpty()
                || (str.length() % 2 == 1
                && charList.size()
                == 1)) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {

        if(canFormPalindrome("ab")){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
