package com.ms.medium.arrays;

import java.util.*;

/**
 * Find unique triplets in an unsorted array having sum is 0
 */
public class UniqueTriplets {

    public List<List<Integer>> getUniqueTriplets(int[] nums){
        Set<List<Integer>> set=new HashSet<>();
        if(nums.length==0) return new ArrayList<>();
        int sum=0;
        for(int i=0;i<nums.length-2;i++)
        {
            int j=i+1;
            int k=nums.length-1;
            while(j<k)
            {
                sum=nums[i]+nums[j]+nums[k];
                if(sum==0) set.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                if(sum<0) j++;
                if(sum>0) k--;

            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        new UniqueTriplets().getUniqueTriplets(new int[]{0, -1, 2, -3, 1}).stream().forEach(System.out::print);
    }
}
