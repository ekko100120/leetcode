package com.kenny.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//根据一个前序遍历list构成一个二叉树，二叉树结点为空的地方为-1.
public class Tree1 {

  public static  final  String  data ="1,2,0,4,0,0,3,0,0";

  TreeNode deserialize(String data){

      LinkedList<String> nodes = new LinkedList<>();
      for (String s : data.split(",")){
          nodes.addLast(s);
      }
      return  deserialize(nodes);
  }

    private TreeNode deserialize(LinkedList<String> nodes) {
      if (nodes.isEmpty()) {
          return  null;
      }
      String first = nodes.removeFirst();
      if (first.equals("0")){
        return null;
      }
      TreeNode root = new TreeNode(Integer.valueOf(first));
      root.left = deserialize(nodes);
      root.right = deserialize(nodes);

      return  root;
    }

    public static void main(String[] args) {
        for (String s : data.split(",")){
            System.out.println(s);
        }
    }
}
