package com.leetcode.myCode;

public class L110_BalancedBinaryTree {
    //自顶向下算法
    public int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
    public boolean isBalanced01(TreeNode root) {
        if (root == null) return true;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.abs(left - right) <= 1 && isBalanced01(root.left) && isBalanced01(root.right);
    }

    //自底向上算法
    public int depth02(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = depth02(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = depth02(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public boolean isBalanced02(TreeNode root) {
        return depth02(root) != -1;
    }
}
