package com.leetcode.myCode;

public class L124_BinaryTreeMaximumPathSum {
    public int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getSum(root);
        return maxSum;
    }
    public int getSum(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, getSum(root.left));
        int right = Math.max(0, getSum(root.right));
        maxSum = Math.max(maxSum, left+right+root.val);
        return Math.max(right, left) + root.val;
    }
}
