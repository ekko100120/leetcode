package com.kenny.leetcode.二叉树.二叉搜索树;

import com.kenny.leetcode.TreeNode;

public class LeetCode897 {

    //897. 递增顺序查找树
    //https://leetcode-cn.com/problems/increasing-order-search-tree/

    public TreeNode node;
    public TreeNode preNode;
    public TreeNode increasingBST(TreeNode root) {
        reConstruct(root);
        return node;
    }

    public void reConstruct(TreeNode root){
        if(root == null){
            return ;
        }
        reConstruct(root.left);
        if(preNode== null){
            node = root;
            preNode =root;
        }else{
            preNode.right =root;
            root.left = null;
            preNode = root;
        }
        reConstruct(root.right);

    }
}
