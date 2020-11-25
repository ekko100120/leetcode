package com.kenny.leetcode.二叉树.二叉搜索树;

import com.kenny.leetcode.TreeNode;

public class LeetCode108 {


    //108. 将有序数组转换为二叉搜索树
    //https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums,0, nums.length-1);
    }

    public TreeNode convert(int[] nums, int left, int right){
        if(nums == null || nums.length ==0){
            return null;
        }
        if(left> right){
            return null;
        }
        int mid = left+(right-left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left= convert(nums,left,mid-1);
        node.right= convert(nums,mid+1,right);
        return node;
    }
}
