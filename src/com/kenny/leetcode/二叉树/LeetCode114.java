package com.kenny.leetcode.二叉树;

import com.kenny.leetcode.TreeNode;

import java.util.LinkedList;

public class LeetCode114 {


    LinkedList list = new LinkedList();

    public void flatten(TreeNode root) {

    }

    public void  reverseNode(TreeNode root){
        if (root ==null){
            return;
        }

        list.add(root);
        reverseNode(root.left);
        reverseNode(root.right);
    }

}
