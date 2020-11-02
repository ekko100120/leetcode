package com.kenny.leetcode.动态规划.买卖股票;

public class LeetCode123 {

 /*   给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

    设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

    注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。*/

  // 思路: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/dong-tai-gui-hua-by-liweiwei1419-7/

    public int maxProfit(int[] prices) {


        int length = prices.length;
        if (length<2){
            return 0;
        }
        int k =2;
        // dp[a][b][c] a 代表数组prices的index.
        // b 代表交易的次数
        // c代表是否持有股票，只能为0或者1
        int[][][] dp = new int[length][k+1][2];
        dp[0][1][1] = -prices[0];
        dp[0][2][1] =Integer.MIN_VALUE;
        for (int i = 1; i < length ; i++) {
             //在i天时， 交易一次的情况下持有该股票 包含
            // case1: i-1天时 就已经交易一次并持有股票了
            // case2: i-1天时 没有发生交易，第i天时发生交易，买入当天的股票， 所以此时收益为 --prices[i]
            dp[i][1][1] = Math.max(dp[i-1][1][1], -prices[i]);
            //在i天时， 交易一次的情况下不持有该股票 包含
            // case1: i-1天时 就已经交易一次(买 卖)并不持有股票了
            // case2: i-1天时 购买了股票，第i天时发生交易，卖出当天的股票， 所以此时收益为 dp[i-1][1][1] + prices[i]
            dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][1][1] + prices[i]);
            //在i天时， 交易2次的情况下持有该股票 包含
            // case1: i-1天时 就已经交易2次(买 卖)并持有股票了
            // case2: i-1天时 发生过1次交易并不持有，第i天时，买当天的股票，所以此时收益为 dp[i-1][1][0] - prices[i]
            dp[i][2][1] = Math.max(dp[i-1][2][1], dp[i-1][1][0] - prices[i]);
            //在i天时， 交易2次的情况下不持有该股票 包含
            // case1: i-1天时 就已经交易2次(买 卖)并不持有股票了
            // case2: i-1天时 发生过2次交易持有，第i天时，卖出当天的股票，所以此时收益为 dp[i-1][2][1] + prices[i]
            dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i-1][2][1] + prices[i]);

        }
        return Math.max(dp[length-1][1][0], dp[length-1][2][0]);


    }

}
