package com.leetcode.myCode;

public class L404_SumOfLeftLeaves {
    public int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root != null) preorderWalk(root);
        return sum;
    }
    public void preorderWalk(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            if (root.left.right == null && root.left.left == null) sum += root.left.val;
        }
        preorderWalk(root.left);
        preorderWalk(root.right);
    }
}
