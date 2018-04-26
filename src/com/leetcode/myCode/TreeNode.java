package com.leetcode.myCode;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static TreeNode initTree() {
        TreeNode a1 = new TreeNode(3);
        TreeNode a2 = new TreeNode(9);
        TreeNode a3 = new TreeNode(20);
        TreeNode a4 = new TreeNode(15);
        TreeNode a5 = new TreeNode(7);
        a1.left = a2;
        a1.right = a3;
        a3.left = a4;
        a3.right = a5;
        return a1;
    }

    public static TreeNode initTree01() {
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(4);
        TreeNode a3 = new TreeNode(8);
        TreeNode a4 = new TreeNode(11);
        TreeNode a5 = new TreeNode(13);
        TreeNode a6 = new TreeNode(4);
        TreeNode a7 = new TreeNode(7);
        TreeNode a8 = new TreeNode(2);
        TreeNode a9 = new TreeNode(1);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a3.left = a5;
        a3.right = a6;
        a4.left = a7;
        a4.right = a8;
        a6.right = a9;
        return a1;
    }

    public static TreeNode initTree02() {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        TreeNode a7 = new TreeNode(7);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = a6;
        a3.right = a7;
        return a1;
    }

    public static TreeNode initTree03() {
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(-3);
        a1.left = a2;
        a1.right = a3;
        return a1;
    }
}
