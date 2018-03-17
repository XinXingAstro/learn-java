package com.offer.tree;

/**
 * 输入一个二叉树，输出二叉树的镜像
 * 算法：交换每个节点的左右子树
 */
public class O27_MirrorTree {
    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            mirror(root.left);
        }
        if (root.right != null) {
            mirror(root.right);
        }
    }
}
