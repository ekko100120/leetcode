package com.kenny.leetcode.二叉树.二叉搜索树;

import com.kenny.leetcode.TreeNode;

public class LeetCode538 {

    //538. 把二叉搜索树转换为累加树
    /*
    给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
    使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
    */

    //思想: 从右往左的中序遍历结果和即为 每个节点的累加值
    public int sum = 0;

    public TreeNode convertBST(TreeNode root) {

        if (root == null){
            return null;
        }
        convertBST(root.right);
        sum = sum + root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }


}
