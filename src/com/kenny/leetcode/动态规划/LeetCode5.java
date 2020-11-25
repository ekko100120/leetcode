package com.kenny.leetcode.动态规划;

public class LeetCode5 {

    /*最长子回文*/

    public String longestPalindrome(String s) {
        if (s == null ||s.length() ==1){
            return  s;
        }
        String res = null ;
        for (int i = 0; i <s.length() ; i++) {
            String s1 = palindrome(s,i,i);
            String s2 = palindrome(s, i,i+1);
            res = res!= null && res.length()>s1.length()? res:s1;
            res = res!= null && res.length()>s2.length()? res:s2;
        }
        return res;
    }

    public String palindrome(String s, int l, int r){
        while (l>=0 && r<s.length()&&s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
        // substring 是包含左闭右开   012345 substring(1,3) --> 12
        return s.substring(l+1, r);
    }

    //动态规划解法
    public String longestPalindrome1(String s) {
        if(s== null){
            return "";
        }
        String result = s.substring(0,1);

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxlength =0;

        for(int i=0; i<n; i++){
            dp[i][i] = true;
        }
        for(int j =1; j<n; j++){
            for(int i =0; i<j; i++){

                //j-i<3的含义表示的是 aba aa这两种情况肯定是回文子串
                dp[i][j] = (s.charAt(i)==s.charAt(j)&&(j-i<3 || dp[i+1][j-1]));
                if(dp[i][j]){
                    if(j-i+1 > maxlength){
                        maxlength = j-i+1;
                        result = s.substring(i,j+1);
                    }

                }
            }

        }
        return result;
    }
}
