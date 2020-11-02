package com.kenny.leetcode.二叉树.序列化;

import com.kenny.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode297 {



    public static  class 层序遍历{

        // 把一棵二叉树序列化成字符串
        public String serialize(TreeNode root) {

            StringBuilder builder = new StringBuilder();
            serialize(root,builder);
            return builder.toString();

        }

        // 把一棵二叉树序列化成字符串
        public void serialize(TreeNode root, StringBuilder builder) {
            if (root == null){
                builder.append("#").append(",");
                return ;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){

                TreeNode node = queue.poll();
                if (node== null){
                    builder.append("#").append(",");
                    continue;
                }

                builder.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);

            }


        }

        public TreeNode deserialize(String data) {
            if ( data.isEmpty()){
                return null;
            }
            String[] nodes = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            for (int i = 1; i < nodes.length ; ) {
                TreeNode node = queue.poll();
                String left = nodes[i++];
                if (!"#".equals(left)){
                    node.left = new TreeNode(Integer.parseInt(left));
                    queue.offer(node.left);
                }else {
                    node.left = null;
                }
                String right = nodes[i++];
                if (!"#".equals(right)){
                    node.right = new TreeNode(Integer.parseInt(right));
                    queue.offer(node.right);
                }else {
                    node.right = null;
                }
            }
            return  root;
        }

    }


    public static class 后续遍历{

        // 把一棵二叉树序列化成字符串
        public String serialize(TreeNode root) {

            StringBuilder builder = new StringBuilder();
            serialize(root,builder);
            return builder.toString();

        }

        // 把一棵二叉树序列化成字符串
        public void serialize(TreeNode root, StringBuilder builder) {
            if (root == null){
                builder.append("#").append(",");
                return ;
            }

            serialize(root.left, builder);
            serialize(root.right, builder);
            builder.append(root.val).append(",");
        }

        // 把字符串反序列化成二叉树
        public TreeNode deserialize(String data) {
            LinkedList<String> linkedList = new LinkedList<>();
            String[] list = data.split(",");
            for (int i = 0; i <list.length ; i++) {
                linkedList.addFirst( list[i]);
            }
            return  deserialize(linkedList);
        }

        public TreeNode deserialize(LinkedList<String> dataList) {

            if (dataList.isEmpty()){
                return null;
            }
            String value = dataList.removeLast();
            if ("#".equals(value)){
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(value));
            root.right = deserialize(dataList);
            root.left = deserialize(dataList);
            return root;

        }

    }

    public static class 前序遍历 {

        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            serialize(root,builder);
            return builder.toString();
        }

        // 把一棵二叉树序列化成字符串
        public void serialize(TreeNode root, StringBuilder builder) {
            if (root == null){
                builder.append("#").append(",");
                return ;
            }
            builder.append(root.val).append(",");

            serialize(root.left, builder);
            serialize(root.right, builder);
        }

        // 把字符串反序列化成二叉树
        public TreeNode deserialize(String data) {

            LinkedList<String> linkedList = new LinkedList<>();
            String[] list = data.split(",");
            for (int i = 0; i <list.length ; i++) {
                linkedList.addFirst( list[i]);
            }
            return  deserialize(linkedList);

        }

        public TreeNode deserialize(LinkedList<String> dataList) {
            if (dataList.isEmpty()){
                return null;
            }
            String value = dataList.removeFirst();
            if ( "#".equals(value)){
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(value));
            root.left = deserialize(dataList);
            root.right = deserialize(dataList);
            return root;

        }
    }
}
