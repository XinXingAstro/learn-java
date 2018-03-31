package com.leetcode.myCode;

public class L99_RecoverBinarySearchTree {
    public TreeNode preNode = null;
    public TreeNode node1 = null;
    public TreeNode node2 = null;

    public void recoverTree(TreeNode root) {
        if (root == null) return;

        inorderWalk(root);

        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
    public void inorderWalk(TreeNode root) {
        if (root == null) return;

        inorderWalk(root.left);

        if (node1 == null && preNode != null && preNode.val > root.val)
            node1 = preNode;
        if (node1 != null && preNode != null && preNode.val > root.val)
            node2 = root;
        preNode = root;

        inorderWalk(root.right);
    }
}
