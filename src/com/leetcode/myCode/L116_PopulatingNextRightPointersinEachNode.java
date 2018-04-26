package com.leetcode.myCode;

public class L116_PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        while (root != null && root.left != null) {
            TreeLinkNode pNode = root;
            while (pNode != null) {
                pNode.left.next = pNode.right;
                pNode.right.next = pNode.next == null ? null : pNode.next.left;
                pNode = pNode.next;
            }
            root = root.left;
        }
    }
}
