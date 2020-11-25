package com.kenny.leetcode.二叉树.二叉搜索树;

import com.kenny.leetcode.TreeNode;

public class LeetCode230 {

    public int result = 0;
    public int rank =0;
    //230. 二叉搜索树中第K小的元素
    // https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
    //核心思想 二叉搜索树的中序遍历是递增的
    public int kthSmallest(TreeNode root, int k) {
          traverse(root,k);
          return result;
    }

    public void traverse(TreeNode root, int k){
        if (root == null){
            return;
        }
        traverse(root.left, k);
        rank++;
        if (rank ==k){
            result = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
