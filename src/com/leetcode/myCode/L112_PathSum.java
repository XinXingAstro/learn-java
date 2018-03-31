package com.leetcode.myCode;

public class L112_PathSum {
    public boolean ans = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        preorderWalk(root, 0, sum);
        return ans;
    }
    public void preorderWalk(TreeNode root, int pathSum, int sum) {
        if (root == null || ans == true) return;
        pathSum += root.val;
        if (root.left == null && root.right == null && pathSum == sum) ans = true;
        preorderWalk(root.left, pathSum, sum);
        preorderWalk(root.right, pathSum, sum);
        pathSum -= root.val;
    }
}
