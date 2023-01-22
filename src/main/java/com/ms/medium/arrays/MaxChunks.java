package com.ms.medium.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  https://leetcode.com/problems/max-chunks-to-make-sorted/
 *  You are given an integer array arr of length n that represents a permutation of the integers
 *  in the range [0, n - 1]. We split arr into some number of chunks (i.e., partitions), and
 *  individually sort each chunk. After concatenating them, the result should equal the sorted array.
 *  Return the largest number of chunks we can make to sort the array.
 */
public class MaxChunks {

    public int maxChunksToSorted(int[] array){
        int n = array.length;
        int[] minOfRight = new int[n];
        minOfRight[n-1] = array[n-1];

        for (int i=n-2;i>0;i--){
            minOfRight[i] = Math.min(minOfRight[i+1], array[i]);
        }
        Arrays.stream(minOfRight).forEach(System.out::print);
        int result=0;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<n-1;i++){
            max = Math.max(max, array[i]);
            if(max <= minOfRight[i+1]){
                result++;
            }
        }
        return result+1;
    }

    public static void main(String[] args) {
        System.out.println(new MaxChunks().maxChunksToSorted(new int[]{2,4,1,6,5,9,7}));
    }
}
