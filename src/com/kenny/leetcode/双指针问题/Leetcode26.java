package com.kenny.leetcode.双指针问题;

public class Leetcode26 {

    //删除排序数组中的重复项

    public int removeDuplicates(int[] nums) {

        int length = nums.length;
        int i=0, j=1;

        while (j<length){

            if (nums[i] != nums[j]){
                i++;
                nums[i] =nums[j];
            }
            j++;
        }
        return i+1;

    }
}
