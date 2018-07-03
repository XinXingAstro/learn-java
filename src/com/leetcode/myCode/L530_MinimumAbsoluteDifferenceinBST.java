package com.leetcode.myCode;

public class L530_MinimumAbsoluteDifferenceinBST {
    private int dis = Integer.MAX_VALUE;
    private TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        preOrderWalk(root);
        return dis;
    }
    public void preOrderWalk(TreeNode root) {
        if (root == null) return;

        preOrderWalk(root.left);
        if (pre != null && root.val - pre.val < dis)
            dis = root.val - pre.val;
        pre = root;
        preOrderWalk(root.right);
    }
}
