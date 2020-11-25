package com.kenny.leetcode.二叉树.BFS;

import com.kenny.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode637 {

    //637. 二叉树的层平均值(层序遍历)
    //https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/

    public List<Double> averageOfLevels(TreeNode root) {

        if(root == null){
            return null;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        List<Double> results = new ArrayList<>();
        list.offer(root);
        while( !list.isEmpty()){
            Double sum = 0.0;
            int size = list.size();
            for(int i =0; i<size ; i++){
                TreeNode node = list.poll();
                sum+= node.val;
                if(node.left != null){
                    list.offer(node.left);
                }
                if(node.right != null){
                    list.offer(node.right);
                }
            }
            double average = sum/size;
            results.add(average);
        }
        return results;
    }
}
