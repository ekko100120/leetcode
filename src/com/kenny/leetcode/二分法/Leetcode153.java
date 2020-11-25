package com.kenny.leetcode.二分法;

public class Leetcode153 {

    //153. 寻找旋转排序数组中的最小值
    //https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/

    public int findMin(int[] nums, int left, int right) {

        //需要考虑旋转后依然是按照升序排列的情况
        if(nums[left]<=nums[right]){
            return nums[left];
        }

        while(left<= right){
            int mid = left+(right-left)/2;
            if(nums[left] > nums[mid]){
                if(nums[left]>nums[mid] && nums[left+1]<= nums[mid]){
                    return nums[left+1];
                }
                right = mid;
            }else{
                if(nums[right] < nums[mid] && nums[right-1]>= nums[mid]){
                    return nums[right];
                }
                left =mid;
            }

        }
        return -1;

    }
    //方法2  https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/xun-zhao-xuan-zhuan-pai-lie-shu-zu-zhong-de-zui-xi/
    public int findMin1(int[] nums, int left, int right) {

        //需要考虑旋转后依然是按照升序排列的情况
        if(nums[left]<=nums[right]){
            return nums[left];
        }

        while(left<= right){
            int mid = left+(right-left)/2;

            if(nums[mid]>= nums[mid+1]){
                return  nums[mid+1];
            }
            if(nums[mid-1]>= nums[mid]){
                return  nums[mid];
            }
            if(nums[0]> nums[mid]){
                right = mid-1;
            }else {
                left = mid+1;
            }

        }
        return -1;

    }
}
