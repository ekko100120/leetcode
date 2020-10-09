package com.kenny.leetcode.动态规划;

public class LeetCode72 {

    // 字符串改变最少修改数


    public int minDistance(String word1, String word2) {

        int rowLength = word1.length();
        int colLength = word2.length();
        int[][] dp = new int[rowLength+1][colLength+1];

        dp[0][0] = 0;
        for (int i = 1; i <=rowLength ; i++) {
            dp[i][0] = dp[i-1][0] +1;
        }
        for (int i = 0; i <= colLength ; i++) {
            dp[0][i] = dp[0][i-1]+1;
        }

        for (int i = 0; i <=rowLength ; i++) {
            for (int j = 0; j <= colLength ; j++) {
                // 如果 word1[i] 与 word2[j] 相等。第 i 个字符对应下标是 i-1
                if (word1.charAt(i-1)== word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j])+1;
                }
            }
        }

        return dp[rowLength][colLength];

    }


}
