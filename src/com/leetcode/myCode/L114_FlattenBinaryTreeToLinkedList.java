package com.leetcode.myCode;

public class L114_FlattenBinaryTreeToLinkedList {
    public TreeNode preNode = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (preNode != null) {
            preNode.left = null;
            preNode.right = root;
        }
        preNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
}
