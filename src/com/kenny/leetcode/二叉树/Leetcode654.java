package com.kenny.leetcode.二叉树;

import com.kenny.leetcode.TreeNode;

public class Leetcode654 {

    // 构造最大二叉树

    /*给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：

    二叉树的根是数组中的最大元素。
    左子树是通过数组中最大值左边部分构造出的最大二叉树。
    右子树是通过数组中最大值右边部分构造出的最大二叉树。
    通过给定的数组构建最大二叉树，并且输出这个树的根节点。*/

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return  build(nums,0, nums.length-1);
    }


    public TreeNode build(int[] nums, int left, int right){

        if (left>right){
            return null;
        }

        int max = Integer.MIN_VALUE;
        int index =left;
        for (int i = left; i <= right ; i++) {
            if (nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = build(nums, left, index-1);
        node.right = build(nums,index+1,right);
        return node;
    }




}
