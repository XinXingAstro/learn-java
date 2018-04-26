package com.leetcode.myCode;

import java.util.ArrayDeque;

public class L226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                if (p.left != null) queue.offer(p.left);
                if (p.right != null) queue.offer(p.right);
                TreeNode tmp = p.left;
                p.left = p.right;
                p.right = tmp;
            }
        }
        return root;
    }

    public TreeNode invertTree02(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
