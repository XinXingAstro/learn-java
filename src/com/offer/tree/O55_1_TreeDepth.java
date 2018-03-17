package com.offer.tree;

/**
 * 输入一个二叉树的根节点，求该二叉树的深度
 * 二叉树深度：从根节点到叶节点依次经过的节点（含根、叶节点）形成的一条路径，最长路径的长度为树的深度
 */
public class O55_1_TreeDepth {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        return (left > right) ? (left + 1) : (right + 1);
    }
}
