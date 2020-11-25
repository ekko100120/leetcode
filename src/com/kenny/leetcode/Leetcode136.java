package com.kenny.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode136 {


    //136. 只出现一次的数字
    //https://leetcode-cn.com/problems/single-number/

    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {

            if (!list.isEmpty() &&list.contains(nums[i])){
                list.remove(nums[i]);
            }else {
                list.add(nums[i]);
            }
        }
        return list.get(0);
    }

    public int singleNumber1(int[] nums) {
        int result =0;
        for (int i = 0; i <nums.length ; i++) {
            result ^= nums[i];
        }
        return  result;
    }
}
