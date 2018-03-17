package com.offer.tree;

public class O7_ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }

        TreeNode root;
        try {
            return constructor(0, pre.length - 1, pre, 0, in.length - 1, in);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public TreeNode constructor(int preStart, int preEnd, int[] pre, int inStart, int inEnd, int[] in) throws Exception {
        //I.Create root node
        TreeNode root = new TreeNode(pre[preStart]);
        root.left = null;
        root.right = null;

        //II.define the end of recursion
        if (preEnd - preStart <= 0) {
            if (inEnd - inStart <= 0) {
                return root;
            } else {
                throw new Exception();
            }
        }

        //III.find root in inorder array
        int rootInorder = inStart;
        while (in[rootInorder] != root.val && rootInorder <= inEnd) {
            rootInorder++;
        }

        //IV.Create left child tree and right child tree
        if (rootInorder - inStart != 0) {
            root.left = constructor(preStart + 1, preStart + (rootInorder - inStart), pre, inStart, rootInorder - 1, in);
        }
        if (inEnd - rootInorder != 0) {
            root.right = constructor(preEnd - (inEnd - rootInorder - 1), preEnd, pre, rootInorder + 1, inEnd, in);
        }

        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeWalk  treeWalk = new TreeWalk();
        O7_ReConstructBinaryTree test = new O7_ReConstructBinaryTree();
        TreeNode root = test.reConstructBinaryTree(pre, in);
        treeWalk.preorderWalk(root);
        System.out.println();
        treeWalk.inorderWalk(root);
        System.out.println();
        treeWalk.postorderWalk(root);
    }
}
