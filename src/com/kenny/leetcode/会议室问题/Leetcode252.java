package com.kenny.leetcode.会议室问题;

import java.util.Arrays;

public class Leetcode252 {

    int[][] nums = {{1,3}, {2,4}, {3,6}};

    // 言归正传，本文解决一个很经典的贪心算法问题 Interval Scheduling（区间调度问题）。给你很多形如 [start, end] 的闭区间，请你设计一个算法，算出这些区间中最多有几个互不相交的区间。
   /* 举个例子，intvs = [[1,3], [2,4], [3,6]]，这些区间最多有 2 个区间互不相交，即 [[1,3], [3,6]]，你的算法应该返回 2。注意边界相同并不算相交。
    这个问题在生活中的应用广泛，比如你今天有好几个活动，每个活动都可以用区间 [start, end] 表示开始和结束的时间，请问你今天最多能参加几个活动呢？
    显然你一个人不能同时参加两个活动，所以说这个问题就是求这些时间区间的最大不相交子集。*/
    void intervalSchedule(int[][] intvs) {
        if(intvs.length ==0){
            return  ;
        }
        Arrays.sort( intvs, (o1,o2)->o1[1]-o2[1]);

    }

    public static void main(String[] args) {
        Leetcode252 leetcode252 = new Leetcode252();
        leetcode252.intervalSchedule( leetcode252.nums);
        System.out.println(leetcode252.nums);
    }

}
