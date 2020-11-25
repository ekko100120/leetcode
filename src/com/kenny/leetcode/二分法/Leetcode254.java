package com.kenny.leetcode.二分法;

public class Leetcode254 {


    //154. 寻找旋转排序数组中的最小值 II
    //https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/

    public int findMin(int[] nums) {

        return  findMin(nums,0, nums.length-1);
    }

    public int findMin(int[] nums,int left, int right) {

        while (left<= right){
            int mid = left+(right-left)/2;
            if(nums[mid]> nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid-1] > nums[mid]){
                return  nums[mid];
            }

            if(nums[left] >= nums[mid]){
                if (nums[left] == nums[mid]){
                    left = left+1;
                }
                right = mid-1;
            }else {

                if(nums[mid] == nums[right]){
                    right = right-1;
                }

                left = mid+1;
            }

        }
        return  -1;

    }
}
