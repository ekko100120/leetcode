package com.kenny.leetcode.二叉树;

import com.kenny.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode105 {

    //根据一个数的前序遍历和中序遍历构造二叉树

    public TreeNode buildTree1(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length ; i++) {
            map.put(inorder[i],i);
        }

        return   build(preorder,0, preorder.length, inorder, 0, inorder.length,map);

    }

    public TreeNode build1(int[] pre, int preStart, int preEnd, int[] in,
                          int inStart, int inEnd, Map<Integer,Integer> indexMap){
        //需要与index 结合起来，左开右闭的时候是==的时候结束
        if (preStart == preEnd){
            return  null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int rootIndex = indexMap.get(pre[preStart]);
        int internal = rootIndex - inStart;
        //注意index是左开右闭的位置
        root.left = build1(pre,preStart+1,preStart+internal+1, in, inStart, rootIndex, indexMap);
        root.right = build1(pre, preStart+internal+1, preEnd, in, rootIndex+1, inEnd, indexMap);
        return  root;
    }


    //默写
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < inorder.length ; i++) {
            map.put(inorder[i],i);
        }

        return  build(preorder,0,preorder.length,inorder,0, inorder.length, map);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {

        if (preStart == preEnd){
            return  null;
        }

        int rootValue = preorder[preStart];
        int rootIndex = map.get(rootValue);
        int internal  = rootIndex - inStart;
        TreeNode root = new TreeNode(rootValue);
        root.left = build( preorder, preStart+1, preStart+internal+1, inorder, inStart, rootIndex, map);
        root.right = build(preorder, preStart+internal+1, preEnd, inorder, rootIndex+1, inEnd, map);
        return root;

    }


}
