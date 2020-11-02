package com.kenny.leetcode.动态规划.买卖股票;

public class LeetCode122 {

   /* 122. 买卖股票的最佳时机 II
    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
    */
    //https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/tuan-mie-gu-piao-wen-ti


    public  int maxProfit(int[] prices) {

        int length = prices.length;
        if (length<=1){
            return 0;
        }
        // dp[a][b] a 代表数组prices的index. b代表是否持有改制股票，只能为0或者1
        int[][] dp = new int[length][2];
        dp[0][0] = 0;

        // 第一天入手后的利润应该是prices[0]*(-1) 而不是 -infinite
        dp[0][1] = prices[0]*(-1);

        for (int i = 1; i < prices.length ; i++) {
            // 第i天不持有股票的 case 包括:
            // 1. 第i-1天不持有股票
            // 2. 第i-1天持有股票。第i天卖出股票

            dp[i][0] = Math.max(dp[i-1][0] , dp[i-1][1]+ prices[i] );
            // 第i天持有股票的 case 包括:
            // 1. 第i-1天持有股票
            // 2. 第i-1天不持有股票。第i天买入出股票
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]- prices[i]);

        }
        return dp[length-1][0];

    }



    // 空间优化
    int maxProfit_k_inf(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = prices[0] * (-1);
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }
}
