package com.kenny.leetcode.二叉树;

import com.kenny.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode199 {

    //Leetcode 199 二叉树的右视图

    // 二叉树的BFS层序遍历变种返回每层的最后一个数字

    public List<Integer> rightSideView(TreeNode root) {

        if (root == null){
            return null;
        }

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int current =1;
        int next=0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            current--;
            if (node.left != null){
                queue.add(node.left);
                next++;
            }

            if (node.right != null){
                queue.add(node.right);
                next++;
            }
            if (current ==0){
                list.add(node.val);
                current = next;
                next =0;
            }
        }
        return list;

    }

}
