package com.leetcode.myCode;

public class L129_SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return getSum(root, 0);
    }
    public int getSum(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) return sum;
        return getSum(root.left, sum) + getSum(root.right, sum);
    }
}
