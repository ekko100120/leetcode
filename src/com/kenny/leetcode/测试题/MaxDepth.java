package com.kenny.leetcode.测试题;

import com.kenny.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaxDepth {


    //递归调用
    public int maxDepth1(TreeNode root) {

        if (root == null){
            return 0;
        }
        int depth = 1+ Math.max(maxDepth(root.left),maxDepth(root.right));
        return depth;

    }

    //层序调用

    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        LinkedList<TreeNode> linkedList =new LinkedList<>();
        linkedList.add(root);
        int maxDepth=0;
        while (!linkedList.isEmpty()){
            maxDepth++;
            //陷阱。需要把length 提取出来， 不然会因为添加子节点长度导致长度变化出错
            int length =linkedList.size();
            for (int i = 0; i <length ; i++) {
                TreeNode node = linkedList.poll();
                if (node.left!=null){
                    linkedList.add(node.left);
                }
                if (node.right!=null){
                    linkedList.add(node.right);
                }
            }
        }
        return maxDepth;

    }
}
