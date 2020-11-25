package com.kenny.leetcode.二叉树.二叉搜索树;

import com.kenny.leetcode.TreeNode;

public class LeetCode98 {

    //98. 验证二叉搜索树 https://leetcode-cn.com/problems/validate-binary-search-tree/

    //思想：1.小心陷阱 二叉搜索树的当前节点值需要大于所有的当前左孩子节点
    //2.对于某一个节点root，他只能管得了自己的左右子节点，怎么把root的约束传递给左右子树呢？
    // 我们通过使用辅助函数，增加函数参数列表，在参数中携带额外信息，
    // 将这种约束传递给子树的所有节点，这也是二叉树算法的一个小技巧吧。
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root,null,null);
    }

    public boolean isValidBST(TreeNode root,TreeNode min, TreeNode max){
        if (root == null){
            return true;
        }
        //注意 等号问题，左孩子节点一定是小于当前节点的
        if (min !=null && root.val <= min.val){
            return false;
        }
        if (max !=null && root.val >= max.val){
            return false;
        }

        return isValidBST(root.left, min, root)&& isValidBST(root.right, root,max);
    }

}
