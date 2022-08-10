package com.ms.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int number = target - nums[i];
            if(map.containsKey(number)){
                result[0] = map.get(number);
                result[1] = i;
            }else{
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
