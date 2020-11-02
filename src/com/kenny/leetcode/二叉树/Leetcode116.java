package com.kenny.leetcode.二叉树;

import com.kenny.leetcode.TreeNode;

public class Leetcode116 {

    //甜筒每个节点的下一个右侧节点
    public TreeNode connect(TreeNode root) {

        if (root == null){
            return null;
        }
        if (root.left !=null){
            root.left.next = root.right;
            if (root.next!=null){
                root.right.next = root.next.left;
            }
        }

        TreeNode left = connect(root.left);
        TreeNode right = connect(root.right);
        return root;
    }
}
