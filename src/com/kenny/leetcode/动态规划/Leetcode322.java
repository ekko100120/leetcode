package com.kenny.leetcode.动态规划;

import java.util.LinkedList;
import java.util.TreeMap;

public class Leetcode322 {

    // 动 态规划之凑零钱问题

    /*给定不同面额的硬币 coins 和一个总金额 amount。
    编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
    如果没有任何一种硬币组合能组成总金额，返回 -1。*/

    public int coinChange(int[] coins, int amount) {

        return  dp(coins,amount);

    }

    public int dp(int[] coins, int amount){

        int[] dp = new int[amount+1];
        for (int i = 0; i <dp.length ; i++) {

            // 初始化最大值为amount+1而不是Integer.Max_value的目的是为了防止加的时候溢出
            dp[i] = amount+1;
        }
        dp[0] =0;

        for (int i = 1; i <=amount ; i++) {

           for (int coin:coins){
               if (i-coin <0){
                   continue;
               }
               // 状态转移方程等同于 dp[i] = min(dp[i-1], dp[i-2], dp[i-5])+1
               dp[i] = Math.min(dp[i], dp[i-coin]+1);
           }

        }

        return dp[amount] == amount+1? -1: dp[amount];

    }

}
