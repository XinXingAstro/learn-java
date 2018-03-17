package com.offer.tree;

/**
 * 判断树2是不是树1的子结构
 * 算法：
 * I.递归遍历树1找到和树2一样的根节点
 * II.找到一样的节点后，判断两个树的结构是否相同
 */
public class O26_HasSubtree {
    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = doesTree1HasTree2(root1, root2);
            }
            if (!result) {
                result = hasSubtree(root1.left, root2);
            }
            if (!result) {
                result = hasSubtree(root1.right, root2);
            }
        }

        return result;
    }

    public boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(8);
        TreeNode a2 = new TreeNode(8);
        TreeNode a3 = new TreeNode(7);
        TreeNode a4 = new TreeNode(9);
        TreeNode a5 = new TreeNode(2);
        TreeNode a6 = new TreeNode(4);
        TreeNode a7 = new TreeNode(7);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a5.left = a6;
        a5.right = a7;

        TreeNode b1 = new TreeNode(8);
        TreeNode b2 = new TreeNode(8);
        TreeNode b3 = new TreeNode(8);
        b1.left = b2;
        b1.right = b3;

        O26_HasSubtree test = new O26_HasSubtree();
        System.out.print(test.hasSubtree(a1, b1));
    }
}
