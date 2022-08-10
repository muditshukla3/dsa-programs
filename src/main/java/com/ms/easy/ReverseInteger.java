package com.ms.easy;

public class ReverseInteger {

    public int reverse(int input){

        int number = Math.abs(input);
        int result= 0;

        while(number>0){
            int lastDigit = number % 10;
            result = result * 10 + lastDigit;
            number = (int)Math.floor(number /10);
        }

        return result;
    }
}
