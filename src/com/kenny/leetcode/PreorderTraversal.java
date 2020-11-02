package com.kenny.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root,list);
        return  list;
    }

    public void preorderTraversal(TreeNode root, List<Integer> list){
        if (root == null) {
            return ;
        }

        Integer value = root.val;
        list.add(value);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }
}
