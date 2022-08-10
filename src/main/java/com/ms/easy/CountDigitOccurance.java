package com.ms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a number n and a digit d, count all occurrences of d in range from 0 to n
 * Input :  n = 25
 *          d = 2
 * Output : 9
 * The occurrences are 2, 12, 20, 21
 * 22 (Two occurrences), 23, 24, 25
 */
public class CountDigitOccurance {

    public static int countOccurance(int digit, int inputRange){

        int result=0;
        int itr=digit;
        List<Integer> occurance = new ArrayList<>();
        while(itr<inputRange){

            if(itr%10 == digit){
                result++;
                occurance.add(itr);
            }
            if(itr/10 == digit){
                result++;
                itr++;
                occurance.add(itr);
            }else if(itr/10 == digit-1){
                itr = itr + (10-digit);
            }else{
                itr+=10;
            }
        }
        System.out.println(occurance);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countOccurance(3,39));
    }
}
