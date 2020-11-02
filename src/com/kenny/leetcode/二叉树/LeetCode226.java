package com.kenny.leetcode.二叉树;

import com.kenny.leetcode.TreeNode;

public class LeetCode226 {


    //翻转一颗二叉树

    public TreeNode invertTree(TreeNode root) {

        if (root == null){
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}
