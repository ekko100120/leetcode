package com.kenny.leetcode.二分法;

public class Leetcode81 {

    //81. 搜索旋转排序数组 II
    //https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
    //解题思路:https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/yi-wen-jie-jue-4-dao-sou-suo-xuan-zhuan-pai-xu-s-2/

    public boolean search(int[] nums, int target) {

        return search(nums, 0, nums.length-1, target);
    }

    public boolean search(int[] nums, int start, int end, int target) {

        while(start <=end){
            int mid = start+(end-start)/2;
            if(nums[mid] == target){
                return true;
            }
            // 注意陷阱case: 1,3,1，1 含有重复元素的类型,需要首先排除掉
            if(nums[start] == nums[mid]){
                start++;
                continue;
            }
            if(nums[start]< nums[mid]){
                if(nums[start]<= target && target < nums[mid]){
                    end = mid -1;
                }else{
                    start = mid+1;
                }
            }else{
                if(nums[mid]< target && target <= nums[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }

        }
        return false;

    }
}
