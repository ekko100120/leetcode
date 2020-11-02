package com.kenny.leetcode.动态规划.买卖股票;

public class Leetcode714 {

    /*给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。

    你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。

    返回获得利润的最大值。

    注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续*/

    public int maxProfit(int[] prices,  int fee) {
        int length = prices.length;
        if (length <2){
            return  0;
        }
        int[][] dp = new int[length][2];
        //第0天持有的情况就是全部买入 资产为-prices[0]
        dp[0][1] = -prices[0];
        //第0天不持有的情况 资产为0;
        dp[0][0] = 0;

        // i从1开始
        for (int i = 1; i < length ; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] +prices[i]-fee);
            dp[i][1]= Math.max(dp[i-1][1], dp[i-1][0]- prices[i]);
        }

        return  dp[length-1][0];
    }

}
