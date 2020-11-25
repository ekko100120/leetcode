package com.kenny.leetcode.二叉树;

import com.kenny.leetcode.Node;

import java.util.ArrayList;
import java.util.List;

public class Leetcode590 {

    //590. N叉树的后序遍历
    //https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
    public List<Integer> results = new ArrayList<>();

    public List<Integer> postorder(Node root) {

        search(root);
        return results;
    }

    public void search(Node root) {

        if(root == null){
            return ;
        }

        for(int i=0; i< root.children.size(); i++){
            search(root.children.get(i));
        }
        results.add(root.val);

    }
}
