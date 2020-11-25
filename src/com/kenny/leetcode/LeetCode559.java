package com.kenny.leetcode;

public class LeetCode559 {

    //559. N叉树的最大深度
    //https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
    public int maxDepth(Node root) {
        if (root == null){
            return 0;
        }
        int max =0;
        int result =0;
        for (int i = 0; i < root.children.size(); i++) {
            max = Math.max(max, maxDepth(root.children.get(i)));
        }
        result = max+1;
        return result;
    }


}
