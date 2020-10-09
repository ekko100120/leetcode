package com.kenny.leetcode.动态规划;

public class LeetCode53 {


   /* 前面的解释，自我感觉还是比较形象的，现在让这个解释与动态规划的编程实现结合起来。

    我们定义一个数组dp[]，dp[i]是以第i个元素为结尾的一段最大子序和。求dp[i]时，假设前面dp[0]~dp[i-1]都已经求出来了，dp[i-1]表示的是以i-1为结尾的最大子序和，若dp[i-1]小于0，则dp[i]加上前面的任意长度的序列和都会小于不加前面的序列（即自己本身一个元素是以自己为结尾的最大自序和）。

    所以状态转移方程相当于是一个判断函数。
    if (dp[i - 1] > 0) {
        dp[i] = dp[i - 1] + nums[i];
    } else {
        dp[i] = nums[i];
    }
    */

    public int maxSubArray(int[] nums) {

        if (nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        //如果数字不为空，则最少包含一个子序列
        dp[0] = nums[0];
        int max = dp[0];
        for(int i=1; i<dp.length; i++){
            if (dp[i-1] >0){
                dp[i] = dp[i-1]+nums[i];
            }else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
