package com.leetcode.myCode;

public class L111_MinimumDepthOfBinaryTree {
    public int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        preorderWalk(root, 1);
        return minDepth;
    }
    public void preorderWalk(TreeNode root, int level) {
        if (root == null) return;
        preorderWalk(root.left,level+1);
        preorderWalk(root.right, level+1);
        if (root.left == null && root.right == null && level < minDepth) minDepth = level;
    }
}
