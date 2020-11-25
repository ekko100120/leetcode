package com.kenny.leetcode.二叉树;

import com.kenny.leetcode.TreeNode;

public class LeetCode104 {

    //104. 二叉树的最大深度 easy
    //https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
    //后序遍历
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
