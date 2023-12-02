package com.ms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in nums.
 * Example 1:
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 *
 * Example 2:
 * Input: nums = [1,1]
 * Output: [2]
 */
public class DisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumber = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            int visitIndex = Math.abs(nums[i]) - 1;
            if(nums[visitIndex]>0)
                nums[visitIndex] = -nums[visitIndex];
        }
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>0){
                missingNumber.add(i+1);
            }
        }

        return missingNumber;
    }
}
