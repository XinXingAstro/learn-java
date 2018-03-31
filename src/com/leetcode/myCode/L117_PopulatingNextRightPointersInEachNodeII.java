package com.leetcode.myCode;

import java.util.ArrayDeque;

public class L117_PopulatingNextRightPointersInEachNodeII {
    public static void connect(TreeLinkNode root) {
        if (root == null) return;
        ArrayDeque<TreeLinkNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode pNode = queue.poll();
                if (i != (size-1)) pNode.next = queue.peek();
                if (pNode.left != null) queue.offer(pNode.left);
                if (pNode.right != null) queue.offer(pNode.right);
            }
        }
    }

    public static void connect02(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode preNode = new TreeLinkNode(0);
            TreeLinkNode p = preNode;
            while (root != null) {
                if (root.left != null) {
                    p.next = root.left;
                    p = p.next;
                }
                if (root.right != null) {
                    p.next = root.right;
                    p = p.next;
                }
                root = root.next;
            }
            root = preNode.next;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode a1 = new TreeLinkNode(1);
        TreeLinkNode a2 = new TreeLinkNode(2);
        TreeLinkNode a3 = new TreeLinkNode(3);
        a1.left = a2;
        a1.right = a3;
        connect(a1);
    }
}
