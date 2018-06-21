package com.leetcode.myCode;

public class L814_BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;
        return containOne(root) ? root : null;
    }
    public boolean containOne(TreeNode root) {
        if (root == null) return false;
        boolean left = containOne(root.left);
        boolean right = containOne(root.right);
        if (!left) root.left = null;
        if (!right) root.right = null;
        return root.val == 1 || left || right;
    }
}
