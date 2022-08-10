package com.ms.medium;

public class MaximumSubsequence {

    /**
     * Find maximum sum of non-adjacent element
     * @param nums
     * @return
     */
    public static int findMaxSubSequence(int[] nums){
        // base case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // base case
        if (nums.length == 1) {
            return nums[0];
        }

        int prev_prev = nums[0];
        int prev = Integer.max(nums[0], nums[1]);

        // start from index 2
        for (int i = 2; i < nums.length; i++)
        {
            // `curr` stores the maximum sum until index `i`
            int curr = Integer.max(nums[i], Integer.max(prev, prev_prev + nums[i]));
            prev_prev = prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args)
    {
        int[] nums = { 1, 2, 9, 4, 5, 0, 4, 11, 6 };

        System.out.println("The maximum sum is " + findMaxSubSequence(nums));
    }
}
