package com.kenny.leetcode.二叉树;

import com.kenny.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode652 {

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        traverse(root);
        return res;

    }


    public String traverse(TreeNode root){

        if (root == null){
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left + ',' + right + ','+ root.val;
        int frequence = map.getOrDefault(subTree, 0);

        if (frequence ==1){
            res.add(root);
        }
        map.put(subTree,frequence+1);
        return subTree;

    }
}
