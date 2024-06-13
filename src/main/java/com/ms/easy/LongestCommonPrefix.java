package com.ms.easy;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        int size = strs.length;
        if (size == 0){
            return "";
        } else if (size == 1) {
            return "";
        }else{
            Arrays.sort(strs);
            Arrays.stream(strs).forEach(System.out::println);
            int length = strs[0].length();
            StringBuilder result = new StringBuilder();
            for(int i = 0;i<length;i++){
                if(strs[0].charAt(i) == strs[size-1].charAt(i)){
                    result.append(strs[0].charAt(i));
                }
            }
            return result.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
