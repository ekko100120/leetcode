package com.kenny.leetcode.动态规划;

public class LeetCode64 {

    //动态规划最短路径问题：https://zhuanlan.zhihu.com/p/91582909


    /*步骤一、定义数组元素的含义
    由于我们的目的是从左上角到右下角，最小路径和是多少，那我们就定义 dp[i] [j]的含义为：当机器人从左上角走到(i, j) 这个位置时，最下的路径和是 dp[i] [j]。那么，dp[m-1] [n-1] 就是我们要的答案了。

    注意，这个网格相当于一个二维数组，数组是从下标为 0 开始算起的，所以 由下角的位置是 (m-1, n - 1)，所以 dp[m-1] [n-1] 就是我们要走的答案。
    步骤二：找出关系数组元素间的关系式
    想象以下，机器人要怎么样才能到达 (i, j) 这个位置？由于机器人可以向下走或者向右走，所以有两种方式到达

    一种是从 (i-1, j) 这个位置走一步到达

    一种是从(i, j - 1) 这个位置走一步到达

    不过这次不是计算所有可能路径，而是计算哪一个路径和是最小的，那么我们要从这两种方式中，选择一种，使得dp[i] [j] 的值是最小的，显然有

    dp[i] [j] = min(dp[i-1][j]，dp[i][j-1]) + arr[i][j];// arr[i][j] 表示网格种的值
    步骤三、找出初始值
    显然，当 dp[i] [j] 中，如果 i 或者 j 有一个为 0，那么还能使用关系式吗？答是不能的，因为这个时候把 i - 1 或者 j - 1，就变成负数了，数组就会出问题了，所以我们的初始值是计算出所有的 dp[0] [0….n-1] 和所有的 dp[0….m-1] [0]。这个还是非常容易计算的，相当于计算机图中的最上面一行和左边一列。因此初始值如下：

    dp[0] [j] = arr[0] [j] + dp[0] [j-1]; // 相当于最上面一行，机器人只能一直往左走

    dp[i] [0] = arr[i] [0] + dp[i] [0]; // 相当于最左面一列，机器人只能一直往下走*/


    public int minPathSum(int[][] grid) {

        //行的总长度
        int rowLength = grid.length;
        // 列的总长度
        int colLength = grid[0].length;
        //dp数组表示在(i,j)位置的最短路径
        int[][] dp  = new int[rowLength][colLength];
        dp[0][0] = grid[0][0];
        for (int i = 1; i <rowLength ; i++) {
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for (int i = 1; i < colLength ; i++) {
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }

        for (int i = 1; i <rowLength; i++) {
            for (int j = 1; j <colLength ; j++) {

                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
            }
        }
        return dp[rowLength-1][colLength-1];
    }

}
