package com.leetcode.myCode;

public class L104_MaximumDepthofBinaryTree {
    public int maxDep = 0;
    public int maxDepth(TreeNode root) {
        if (root != null) preorderWalk(root, 1);
        return maxDep;
    }
    public void preorderWalk(TreeNode root, int level) {
        if (root == null) return;
        if (root.left == null && root.right == null) if (level > maxDep) maxDep = level;
        preorderWalk(root.left, level+1);
        preorderWalk(root.right, level+1);
    }
}
