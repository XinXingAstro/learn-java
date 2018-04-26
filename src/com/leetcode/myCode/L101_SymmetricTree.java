package com.leetcode.myCode;

import java.util.LinkedList;

public class L101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                if (p == null) continue;
                queue.offer(p.left);
                queue.offer(p.right);
            }
            LinkedList<TreeNode> tmp = new LinkedList<>(queue);
            while (!tmp.isEmpty()) {
                TreeNode first = tmp.pollFirst();
                TreeNode last = tmp.pollLast();
                if (first == null || last == null) {
                    if (first != null) return false;
                    if (last != null) return false;
                    continue;
                }
                if (first.val != last.val) return false;
            }
        }
        return true;
    }

    public boolean isSymmetric02(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }
    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null) return right == null;
        if (right == null) return false;
        return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
    }
}
