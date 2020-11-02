package com.kenny.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BFS {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list  = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();

        linkedList.offer(root);
        while (!linkedList.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < linkedList.size() ; i++) {
                TreeNode current = linkedList.peek();
                linkedList.poll();
                if (current == null){
                    continue;
                }
                levelList.add(current.val);
                linkedList.add(current.left);
                linkedList.add(current.right);
            }
            if (!levelList.isEmpty()){
                list.add(levelList);
            }
        }
        return list;
    }
}
