package com.leetcode.myCode;

public class L222_CountCompleteTreeNodes {
    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root, right = root;
        int height = 0;
        while (right != null) {
            left = left.left;
            right = right.right;
            height++;
        }
        if (left == null) return (1 << height) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        System.out.print(countNodes(TreeNode.initTree02()));
    }
}
