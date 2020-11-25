package com.kenny.leetcode.二叉树;

import com.kenny.leetcode.TreeNode;

public class LeetCode617 {

    //合并二叉树
    //https://leetcode-cn.com/problems/merge-two-binary-trees/

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 ==null){
            return null;
        }
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        int value = t1.val+t2.val;
        TreeNode tmp = new TreeNode(value);
        tmp.left = mergeTrees(t1.left, t2.left);
        tmp.right = mergeTrees(t1.right, t2.right);
        return tmp;
    }
}
