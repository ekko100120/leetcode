package com.kenny.leetcode.动态规划;

public class LeetCode72 {

    // 字符串改变最少修改数 https://zhuanlan.zhihu.com/p/91582909  https://blog.csdn.net/a553181867/article/details/89008264

   /* 步骤一、定义数组元素的含义
    由于我们的目的求将 word1 转换成 word2 所使用的最少操作数 。
    那我们就定义 dp[i] [j]的含义为：当字符串 word1 的长度为 i，字符串 word2 的长度为 j 时，
    将 word1 转化为 word2 所使用的最少操作次数为 dp[i] [j]。*/

   /* Levenshtein 算法原理
    先从一个问题谈起：对于字符串"xyz"和"xcz"，它们的最短距离是多少？我们从两个字符串的最后一个字符开始比较，它们都是’z’，是相同的，
    我们可以不用做任何操作，此时二者的距离实际上等于"xy"和"xc"的距离，即d(xyz,xcz) = d(xy,xc)。也即是说，如果在比较的过程中，
    遇到了相同的字符，那么二者的距离是除了这个相同字符之外剩下字符的距离。即d(i，j) = d(i - 1,j-1)。

    接着，我们把问题拓展一下，最后一个字符不相同的情况：字符串A(“xyzab”)和字符串B(“axyzc”)，问至少经过多少步操作可以把A变成B。

    我们还是从两个字符串的最后一个字符来考察即’b’和’c’。显然二者不相同，那么我们有以下三种处理办法：
            (1)增加：在A末尾增加一个’c’，那么A变成了"xyzabc"，B仍然是"axyzc"，由于此时末尾字符相同了，
    那么就变成了比较"xyzab"和"axyz"的距离，即d(xyzab,axyzc) = d(xyzab,axyz) + 1。可以写成d(i,j) = d(i,j - 1) + 1。
    表示下次比较的字符串B的长度减少了1，而加1表示当前进行了一次字符的操作。

            (2)删除：删除A末尾的字符’b’，考察A剩下的部分与B的距离。即d(xyzab,axyzc) = d(xyza,axyzc) + 1。
    可以写成d(i,j) = d(i - 1,j) + 1。表示下次比较的字符串A的长度减少了1。

            (3)替换：把A末尾的字符替换成’c’，这样就与B的末尾字符一样了，那么接下来就要考察出了末尾’c’部分的字符，
    即d(xyzab,axyzc) = d(xyza,axyz) + 1。写成d(i,j) = d(i -1,j-1) + 1表示字符串A和B的长度均减少了1。

    由于我们要求的是最短的编辑距离，所以我们取以上三个步骤得出的距离的最小值为最短编辑距离。由上面的步骤可得，这是一个递归的过程，
    因为除掉最后一个字符之后，剩下的字符串的最后一位仍然是最后一个字符，我们仍然可以按照上面的三种操作来进行，经过这样的不断递归，直到比较到第一个字符为止，递归结束。*/

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
