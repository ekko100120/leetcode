package com.kenny.leetcode.动态规划;

public class Leetcode42 {


    //接雨水问题
    //算法核心储水的容量等于 当前位置 左边最高 与右边最高的最小值与当前位置的高度之差
    //小技巧，计算左边最高时与右边最高时包含当前位置可以覆盖 高度只差出现负数的情况


    public int trap(int[] height) {

        return  dp(height);
    }



    //动态规划 leftMax[i] 表示 index为i位置左边最高柱子高度(包含当前位置边界)
    //动态规划 rightMax[i] 表示 index为i位置右边最高柱子高度(包含当前位置边界)
    public int dp(int[] height) {

        // corn case
        if (height.length<=1){
            return 0;
        }

        int totoal =0;
        int length = height.length;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        leftMax[0] =0;
        rightMax[length-1] = height[length-1];
        for (int i = 1; i <length ; i++) {

            leftMax[i] =Math.max( leftMax[i-1], height[i]);
        }
        for (int  i = length-2 ; i >=0 ; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        for (int i = 1; i < length-1 ; i++) {

            totoal += Math.min(leftMax[i],rightMax[i])-height[i];

        }
        return totoal;


    }

    //暴力解法
    public int baoli(int[] height) {

        if (height.length<=1){
            return 0;
        }

        int total =0;
        //i 从1开始 因为index为0的位置肯定不能储水, 不包含length-1
        for (int i = 1; i <height.length-1 ; i++) {
            int leftMax=0, rightMax=0;
            int current = height[i];
            //边界值是包含i的，这样可以覆盖当前位置最高时出现负数的情况。
            for (int j = 0; j <=i ; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            //包含j=i的值，包含length-1
            for (int j = i; j <= height.length-1 ; j++) {
                rightMax = Math.max(rightMax, height[j]);

            }

            total = total+ Math.min(rightMax,leftMax) - current;

        }
        return total;

    }

}
