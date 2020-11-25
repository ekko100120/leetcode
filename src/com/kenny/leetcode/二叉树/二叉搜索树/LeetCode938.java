package com.kenny.leetcode.二叉树.二叉搜索树;

import com.kenny.leetcode.TreeNode;

public class LeetCode938 {

    //938. 二叉搜索树的范围和
    //https://leetcode-cn.com/problems/range-sum-of-bst/
    //二叉搜索树的核心思想是中序遍历
    public int result = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        count(root,L,R);
        return result;

    }

    public void count(TreeNode root, int L, int R) {
        if(root == null){
            return ;
        }
        if(L>R){
            return ;
        }
        count(root.left,L,R);
        if(root.val >=L && root.val<=R){
            result+=root.val;
        }
        count(root.right,L,R);

    }


    //方法二
    // 利用二叉搜索树的性质缩短查找范围，优化时间复杂度
    public int rangeSumBST1(TreeNode root, int L, int R) {
        if(root == null){
            return 0;
        }
        if(root.val<L){
            return rangeSumBST1(root.right,L,R);
        }
        if(root.val>R){
            return rangeSumBST1(root.left,L,R);
        }
        return root.val+ rangeSumBST1(root.left,L,R)+ rangeSumBST1(root.right,L,R);

    }
}
