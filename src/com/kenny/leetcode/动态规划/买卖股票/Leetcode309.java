package com.kenny.leetcode.动态规划.买卖股票;

public class Leetcode309 {

   /* 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

    设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

    你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。*/

   // 思路:https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/tuan-mie-gu-piao-wen-ti


    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <2){
            return  0;
        }
        int[][] dp = new int[length][2];
        //第0天持有的情况就是全部买入 资产为-prices[0]
        dp[0][1] = -prices[0];
        //第0天不持有的情况 资产为0;
        dp[0][0] = 0;
        //第1天不持有的情况分为
        // 1. 第0 and1 天都不买入
        // 2. 第0天买入， 第1天卖出
        dp[1][0] = Math.max(0, prices[1]- prices[0]);
        //第1天持有的情况分为
        // 1. 第0天买入  -prices[0]
        // 2. 第1天买入，  -prices[1]
        dp[1][1] = Math.max(-prices[0], -prices[1]);
        // i从2开始
        for (int i = 2; i < length ; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] +prices[i]);
            dp[i][1]= Math.max(dp[i-1][1], dp[i-2][0]- prices[i]);
        }

        return  dp[length-1][0];
    }
}
