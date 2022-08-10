package com.ms.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("ab", "aba") -> true
 */
public class RansomText {

    public static boolean canRansomTextConstruct(String ransomText, String magzineText){

        Map<Character, Integer> magzineCharCount = new HashMap<>();

        for (char magChar: magzineText.toCharArray()){
            magzineCharCount.put(magChar, magzineCharCount.getOrDefault(magChar, 0)+1);
        }

        for(char ransomChar: ransomText.toCharArray()){
            if(magzineCharCount.containsKey(ransomChar)
                    && magzineCharCount.get(ransomChar) > 0){
                magzineCharCount.put(ransomChar, magzineCharCount.get(ransomChar)-1);
            }else{
                return false;
            }
        }
        return true;
    }
}
