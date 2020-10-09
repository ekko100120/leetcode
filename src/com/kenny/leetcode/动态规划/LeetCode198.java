package com.kenny.leetcode.动态规划;

public class LeetCode198 {

    //打家劫舍问题---->动态规划问题

    /*现在我们是一个小偷，站在第i家的屋顶，我们是偷，还是不偷呢？这是个问题。

    如果偷，那前面一家(i-1)我就不能偷，我当前偷到的最大值就是偷完前(i-2)家的最大值加上我偷这一家的钱。
    如果不偷，我当前偷到的最大值就是偷完前(i-1)加的最大值，然后我就去下一家再看看。
    所以状态转移矩阵就可以用如下一个公式表示：

    rob(i) = Math.max( rob(i - 2) + currentHouseValue, rob(i - 1) )

    第二步是利用状态转移矩阵自底向上求解问题。*/

    public int rob(int[] nums) {

        if (nums.length ==0){
            return 0;
        }
        //
        int[] dp = new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];

        for (int i = 2; i <=nums.length ; i++) {
            // num[i]和dp[i]的索引是相差1的，因为例如dp[2]时. nums的index对应的应该是1
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        return dp[nums.length];

    }
}
