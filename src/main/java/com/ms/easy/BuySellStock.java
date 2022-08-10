package com.ms.easy;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 */
public class BuySellStock {

    public int maxProfit(int[] prices) {
        int leastSoFar = Integer.MAX_VALUE;
        int overAllProfit=0;
        int profitIfSoldToday=0;

        for (int i=0;i<prices.length;i++){
            if(prices[i]<leastSoFar){
                leastSoFar=prices[i];
            }
            profitIfSoldToday = prices[i] - leastSoFar;
            if(overAllProfit<profitIfSoldToday){
                overAllProfit=profitIfSoldToday;
            }
        }

        return overAllProfit;
    }
}
