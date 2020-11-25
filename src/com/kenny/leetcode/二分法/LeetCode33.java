package com.kenny.leetcode.二分法;

public class LeetCode33 {

    //搜索旋转排序数组
    //参考思路: https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/yi-wen-jie-jue-4-dao-sou-suo-xuan-zhuan-pai-xu-s-2/

    public int search(int[] nums, int target) {
        return  search(nums, 0, nums.length-1, target);
    }

    public int search(int[] nums, int start, int end, int target){
        while (start<=end){
            int mid = start+(end-start)/2;
            if(target == nums[mid]){
                return mid;
            }
            //如果nums[0]小于等于nums[mid] 则说明 前半段是有序的;
            if(nums[start]<= nums[mid]){
                // 注意 num[start] 和nums(end)是可以==的
                if(nums[start]<=target && target< nums[mid]){
                    end = mid -1;
                }else {
                    start = mid+1;
                }
            }else{
                if(nums[mid] < target && target<=nums[end]){
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            }
        }
        return  -1;
    }
}
