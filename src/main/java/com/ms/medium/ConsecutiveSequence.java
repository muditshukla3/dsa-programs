package com.ms.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 * Example:
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class ConsecutiveSequence {

    public static int longestConsecutiveSeqLength(int[] inputArray){

        Set<Integer> numSet = new HashSet<>();
        for(int i: inputArray)
            numSet.add(i);

        int longestStreak=0;

        for(int num: inputArray){
            if(!numSet.contains(num-1)){
                int currentNum = num;
                int currentStreak=1;

                while(numSet.contains(currentNum+1)){
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
