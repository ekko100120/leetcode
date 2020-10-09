package com.kenny.leetcode.动态规划;

public class LeetCode63 {

    //动态规范不同路径Ⅱ

    /*步骤一、定义数组元素的含义
    由于我们的目的是从左上角到右下角一共有多少种路径，那我们就定义 dp[i] [j]的含义为：当机器人从左上角走到(i, j) 这个位置时，一共有 dp[i] [j] 种路径。那么，dp[m-1] [n-1] 就是我们要的答案了。

    注意，这个网格相当于一个二维数组，数组是从下标为 0 开始算起的，所以 右下角的位置是 (m-1, n - 1)，所以 dp[m-1] [n-1] 就是我们要找的答案。
    步骤二：找出关系数组元素间的关系式
    想象以下，机器人要怎么样才能到达 (i, j) 这个位置？由于机器人可以向下走或者向右走，所以有两种方式到达

    一种是从 (i-1, j) 这个位置走一步到达,如果此时[i,j] 为1 则此路不通，否则表示此路可通

    一种是从(i, j - 1) 这个位置走一步到达,如果此时[i,j] 为1 则此路不通，否则表示此路可通

    因为是计算所有可能的步骤，所以是把所有可能走的路径都加起来，所以关系式是 dp[i] [j] = dp[i-1] [j] + dp[i] [j-1]。

    步骤三、找出初始值
    显然，当 dp[i] [j] 中，如果 i 或者 j 有一个为 0，那么还能使用关系式吗？答是不能的，因为这个时候把 i - 1 或者 j - 1，就变成负数了，数组就会出问题了，所以我们的初始值是计算出所有的 dp[0] [0….n-1] 和所有的 dp[0….m-1] [0]。这个还是非常容易计算的，相当于计算机图中的最上面一行和左边一列。因此初始值如下：

    dp[0] [0….n-1] = 1; // 如果obstacleGrid[0,i]为1，则此路不通，为0， 否则路径数为 dp[0][i-1]*/


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int rowLength = obstacleGrid.length;
        int colLength = obstacleGrid[0].length;

        int[][] dp = new int[rowLength][colLength];
        dp[0][0] = obstacleGrid[0][0] ==1 ? 0:1;

        for (int i = 1; i < rowLength ; i++) {

            dp[i][0] = obstacleGrid[i][0] == 1 ? 0: dp[i-1][0];
        }
        for (int i = 1; i <colLength; i++) {
            dp[0][i] = obstacleGrid[0][i-1] == 1? 0:dp[0][i-1];
        }
        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j <colLength ; j++) {

                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }

        }
        return dp[rowLength-1][colLength-1];
    }
}
