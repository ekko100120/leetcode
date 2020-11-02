package com.kenny.leetcode.测试题;

import com.kenny.leetcode.TreeNode;

public class MirrorTree {

    //前序遍历
    public TreeNode mirrorTree1(TreeNode root) {

        if (root == null){
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    //后续遍历
    public TreeNode mirrorTree(TreeNode root) {

        if (root == null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);

        return root;

    }
}
