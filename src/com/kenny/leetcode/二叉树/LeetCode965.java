package com.kenny.leetcode.二叉树;

import com.kenny.leetcode.TreeNode;

public class LeetCode965 {

    //单值二叉树
    //https://leetcode-cn.com/problems/univalued-binary-tree/
    //递归参考思路
    public boolean isUnivalTree(TreeNode root) {

        if(root == null){
            return true;
        }
        boolean flag = true;
        flag = isUnivalTree(root.left);
        flag &= isUnivalTree(root.right);
        if (root.left!= null && root.val != root.left.val){
            flag =false;
        }
        if (root.right!=null && root.val != root.right.val){
            flag = false;
        }
        return flag;
    }
}
