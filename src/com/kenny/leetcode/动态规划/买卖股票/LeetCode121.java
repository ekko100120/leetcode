package com.kenny.leetcode.动态规划.买卖股票;

public class LeetCode121 {

    // 买卖股票的最佳时机

    public int maxProfit(int[] prices) {
        return minOf(prices);
    }

    //min[i] 的含义时 第i天买入的最低值
    public int minOf(int[] prices){

        if (prices.length ==0){
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = 0;
        for (int i = 0; i < prices.length ; i++) {
            if (prices[i]< minPrice){

                minPrice =prices[i];
            }else if ( prices[i] - minPrice >= maxPrice){
                maxPrice = prices[i]- minPrice;
            }
        }
        return maxPrice;

        }

}
