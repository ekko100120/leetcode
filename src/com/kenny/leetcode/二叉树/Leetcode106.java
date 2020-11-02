package com.kenny.leetcode.二叉树;

import com.kenny.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode106 {

    //从中序与后序遍历序列构造二叉树

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length ; i++) {
            map.put(inorder[i], i);
        }

        return  buildTree(
                inorder, 0, inorder.length-1,
                postorder,0, postorder.length-1,
                map
        );

    }


    public TreeNode buildTree(int[] inorder, int inStart, int inEnd,
                              int[] postorder, int postStart, int postEnd,Map<Integer,Integer> map) {

        if (postStart>postEnd || inStart>inEnd){
            return null;
        }

        int rootValue = postorder[postEnd];
        int indexOfInOrder =  map.get(rootValue);
        int internal = inEnd-indexOfInOrder;
        TreeNode node = new TreeNode(rootValue);

        node.left = buildTree(inorder, inStart, indexOfInOrder-1, postorder, postStart,postEnd-internal-1,map);
        node.right = buildTree(inorder,indexOfInOrder+1, inEnd, postorder,postStart, postEnd-1, map);
        return  node;

    }
}
