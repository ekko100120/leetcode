package com.kenny.leetcode.二叉树;

import com.kenny.leetcode.Node;

import java.util.ArrayList;
import java.util.List;

public class LeetCode589 {


    //589. N叉树的前序遍历
    //https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/

    public List<Integer> results = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        preSearch(root);
        return results;
    }

    public void preSearch(Node root) {
        if (root == null){
            return;
        }
        results.add(root.val);
        for (int i = 0; i <root.children.size() ; i++) {
            preSearch(root.children.get(i));
        }
    }
}
