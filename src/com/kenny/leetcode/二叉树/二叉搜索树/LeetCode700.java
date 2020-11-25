package com.kenny.leetcode.二叉树.二叉搜索树;

import com.kenny.leetcode.TreeNode;

public class LeetCode700 {

    //700. 二叉搜索树中的搜索
    //https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
    public TreeNode searchBST(TreeNode root, int val) {

        if( root == null){
            return null;
        }

        if(root.val> val){
            return searchBST(root.left,val);
        }
        if(root.val< val){
            return searchBST(root.right,val);
        }
        return root;

    }
}
