package com.kenny.leetcode.动态规划;

import java.util.HashMap;
import java.util.HashSet;

public class LeetCode10 {

    //正则表达式问题
    //https://leetcode-cn.com/problems/regular-expression-matching/

    public boolean isMatch(String s, String p) {

        int sLength = s.length();
        int pLength = p.length();
        //dp表示text从i开始到最后，pattern 从j开始到最后是否匹配
        boolean[][] dp = new boolean[sLength+1][pLength+1];
        dp[sLength][pLength] = true;
        for (int i = sLength; i >= 0 ; i--) {
            for (int j = pLength; j >=0; j--) {
                //dp[sLength][pLength] = true; 已经初始化过
                if (i== sLength && j == pLength){
                    continue;
                }
                boolean firstMatch = i<sLength&& j< pLength
                        &&(s.charAt(i) == p.charAt(j)|| p.charAt(j)== '.');

                if(j+1 < pLength && p.charAt(j+1)=='*'){
                    //dp[i][j] = dp[i][j+2] 表示*匹配0个的意思
                    //dp[i][j] = firstMatch &&dp[i+1][j]表示*匹配多个的意思;
                    //没搞明白
                    dp[i][j] = dp[i][j+2] || (firstMatch &&dp[i+1][j]);
                }else {
                    dp[i][j] = firstMatch && dp[i+1][j+1];
                }

            }

        }
        return dp[0][0];

    }
}
