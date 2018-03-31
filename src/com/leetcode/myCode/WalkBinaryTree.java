package com.leetcode.myCode;

import java.util.*;

public class WalkBinaryTree {
    public void inorderWalk(TreeNode root) {
        if (root != null) {
            inorderWalk(root.left);
            System.out.print(root.val);
            inorderWalk(root.right);
        }
    }
    public void iterativeInorderWalk(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                System.out.print(p.val);
                p = p.right;
            }
        }
    }

    public void preorderWalk(TreeNode root) {
        if (root != null) {
            System.out.print(root.val);
            preorderWalk(root.left);
            preorderWalk(root.right);
        }
    }
    public void iterativePreorderWalk(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                System.out.print(p.val);
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.right;
            }
        }
    }

    public void postorderWalk(TreeNode root) {
        if (root != null) {
            postorderWalk(root.left);
            postorderWalk(root.right);
            System.out.print(root.val);
        }
    }
    public void iterativePostorderWalk(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayDeque<TreeNode> resStack = new ArrayDeque<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                resStack.push(p);
                stack.push(p);
                p = p.right;
            }
            if (!stack.isEmpty()) {
                p = stack.pop().left;
            }
        }
        while (!resStack.isEmpty()) {
            System.out.print(resStack.pop().val);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        LinkedList<Integer> res = new LinkedList<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                res.push(p.val);
                stack.push(p);
                p = p.right;
            }
            if (!stack.isEmpty()) {
                p = stack.pop().left;
            }
        }
        return res;
    }

    public void levelOrderWalk(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            System.out.print(p.val);
            if (p.left != null) {
                queue.offer(p.left);
            }
            if (p.right != null) {
                queue.offer(p.right);
            }
        }
    }


}
