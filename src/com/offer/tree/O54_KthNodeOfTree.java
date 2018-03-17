package com.offer.tree;

/**
 * 找出二叉搜索树的第K大节点
 * 算法：
 * 中序遍历二叉搜索树的结果正好是递增序列，只要在中序遍历的基础上找到第K个节点即可
 */
public class O54_KthNodeOfTree {
    public int index = 0;
    TreeNode target = null;

    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }

        index = k;
        return KthNodeCore(pRoot);
    }
    public TreeNode KthNodeCore(TreeNode pNode) {

        if (pNode.left != null) {
            target = KthNodeCore(pNode.left);
        }

        if (target == null) {
            if (index == 1) {
                target = pNode;
            }
            index--;
        }

        if (target == null && pNode.right != null) {
            target = KthNodeCore(pNode.right);
        }

        return target;
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(8);
        TreeNode a2 = new TreeNode(6);
        TreeNode a3 = new TreeNode(10);
        TreeNode a4 = new TreeNode(5);
        TreeNode a5 = new TreeNode(7);
        TreeNode a6 = new TreeNode(9);
        TreeNode a7 = new TreeNode(11);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = a6;
        a3.right = a7;
        O54_KthNodeOfTree test = new O54_KthNodeOfTree();
        System.out.print(test.KthNode(a1, 2).val);
    }
}
