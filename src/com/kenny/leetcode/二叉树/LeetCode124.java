package com.kenny.leetcode.二叉树;

import com.kenny.leetcode.TreeNode;

public class LeetCode124 {

    // 计算二叉树的最大路径和
    // notify: max值应该整数最小值，否则会导致错误。
    public int max = Integer.MIN_VALUE;


//    首先，考虑实现一个简化的函数 maxGain(node)，该函数计算二叉树中的一个节点的最大贡献值，具体而言，
//    就是在以该节点为根节点的子树中寻找以该节点为起点的一条路径，使得该路径上的节点值之和最大
    public int oneSideMaxPathSum(TreeNode root) {

        if (root == null){
            return 0;
        }

        int left = Math.max(0, oneSideMaxPathSum(root.left));
        int right = Math.max(0, oneSideMaxPathSum(root.right));
        max = Math.max(max, left+right+root.val);
        return Math.max(left,right)+ root.val;

    }
}
