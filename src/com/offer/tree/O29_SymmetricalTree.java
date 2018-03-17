package com.offer.tree;

/**
 * 判断一个二叉树是否对称
 * 算法：递归的判断这个二叉树的每一个节点的左子节点值和右子节点值是否相等
 * 为了监测所有节点值都相等的二叉树时候对称，检测是要加上叶子节点下面的null节点
 */
public class O29_SymmetricalTree {
    public boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    public boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null) {
            return true;
        }
        if (pRoot1 == null || pRoot2 == null) {
            return false;
        }
        if (pRoot1.val != pRoot2.val) {
            return false;
        }
        return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
    }
}
