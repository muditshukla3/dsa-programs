package com.ms.easy;

public class ArrayProductExceptSelf {

    public static int[] productExceptSelf(int[] input){
        int[] result = new int[input.length];

        int left = 1;
        int right = 1;

        for (int i=0;i<input.length;i++){
            result[i] = left;
            left *= input[i];
        }

        for (int i = input.length-1;i>=0;i--){
            result[i] *= right;
            right *= input[i];
        }
        return result;
    }

}
