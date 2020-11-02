package com.kenny.leetcode.测试题;

import com.kenny.leetcode.TreeNode;

public class LessHightTree {

    //https://leetcode-cn.com/problems/minimum-height-tree-lcci/

    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums==null || nums.length==0){
            return null;
        }

        return  helper(nums,0, nums.length-1);

        //给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
    }

    //核心思想，高度最小的二叉搜索树，则根节点一定是中间节点 才能保证高度最低
    public TreeNode helper(int[] nums, int start, int end){

        if (nums==null || nums.length==0){
            return null;
        }
        if (start>end){
            return null;
        }

        int mid = start+ (end- start)/2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,start,mid-1);
        root.right = helper(nums,mid+1, end);
        return  root;
    }
}
