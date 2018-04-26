package com.leetcode.myCode;

import java.util.ArrayDeque;

public class L173_BinarySearchTreeIterator {
    ArrayDeque<TreeNode> stack = new ArrayDeque<>();

    public L173_BinarySearchTreeIterator(TreeNode root) {
        addAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode p = stack.pop();
        addAll(p.right);
        return p.val;
    }

    public void addAll(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
