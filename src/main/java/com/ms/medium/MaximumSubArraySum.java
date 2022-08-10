package com.ms.medium;

public class MaximumSubArraySum {

    /**
     * Find maxium sum of a subarray
     * subarray would be continuous
     * @param input
     * @return
     */
    public static int maximumSubArraySum(int[] input){

        // base case
        if (input == null || input.length == 0) {
            return 0;
        }
        // base case
        if (input.length == 1) {
            return input[0];
        }
        int maxSoFar = input[0];
        int currentMax = input[0];
        for(int i=1;i<input.length;i++){
            currentMax = currentMax + input[i];
            //decision for starting a new sub array or be part of current subarray
            if(currentMax < input[i]){
                currentMax = input[i];
            }

            if(maxSoFar < currentMax){
                maxSoFar = currentMax;
            }
        }

        return maxSoFar;
    }

}
