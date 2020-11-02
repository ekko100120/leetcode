package com.kenny.leetcode.二叉树;

import com.kenny.leetcode.TreeNode;

public class Leetcode236 {

    // 二叉树的最近公共祖先

   /* 思路：从根节点开始遍历，如果p和q中的任一个和root匹配，那么root就是最低公共祖先。
    如果都不匹配，则分别递归左、右子树，如果有一个 节点出现在左子树，
    并且另一个节点出现在右子树，则root就是最低公共祖先.  如果两个节点都出现在左子树，
    则说明最低公共祖先在左子树中，否则在右子树。
    // 因为后续遍历 所以保证了是最近的公共祖先
*/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null){
            return null;
        }
        if (root ==p ||root ==q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p,q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left!=null && right !=null){
            return root;
        }
        if (left ==null){
            return right;
        }
        return left;

    }

}
