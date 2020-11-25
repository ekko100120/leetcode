package com.kenny.leetcode.二叉树.二叉搜索树;

import com.kenny.leetcode.TreeNode;

public class ConvertBstToLinkedList {

    public TreeNode pre = null;
    public TreeNode real = null;

    //剑指 Offer 36. 二叉搜索树与双向链表
    // https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
    public TreeNode Convert(TreeNode root) {
        if (root == null){
            return null;
        }

        convert(root);
        return real;

    }

    public void convert(TreeNode root) {
        if (root == null) {
            return;
        }
        convert(root.left);
        if (pre ==null){
            pre = root;
            real = root;
        }else {
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        convert(root.right);
    }
}
