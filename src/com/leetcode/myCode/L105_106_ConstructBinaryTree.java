package com.leetcode.myCode;

import java.util.*;

public class L105_106_ConstructBinaryTree {
    //用前序遍历序列和中序遍历序列重建二叉树
    public TreeNode buildTree01(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return reBuild(preorder, inorder, 0, preorder.length-1, 0, map);
    }
    public TreeNode reBuild(int[] pre, int[] in, int preStart, int preEnd, int inStart, HashMap<Integer, Integer> map) {
        if (preStart > preEnd) {
            return null;
        }
        int inRoot = map.get(pre[preStart]);
        int lengthOfLeft = inRoot - inStart;
        TreeNode root = new TreeNode(pre[preStart]);
        root.left = reBuild(pre, in, preStart+1, preStart+lengthOfLeft, inRoot-lengthOfLeft, map);
        root.right = reBuild(pre, in, preStart+lengthOfLeft+1, preEnd, inRoot+1, map);
        return root;
    }

    //用中序遍历序列和后序遍历序列重建二叉树
    public TreeNode buildTree02(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return reBuild02(inorder, postorder, 0, postorder.length - 1, 0, map);
    }
    public TreeNode reBuild02(int[] in, int[] pos, int posStart, int posEnd, int inStart, HashMap<Integer, Integer> map) {
        if (posStart > posEnd) {
            return null;
        }
        int inRoot = map.get(pos[posEnd]);
        int lengthOfLeft = inRoot - inStart;
        TreeNode root = new TreeNode(pos[posEnd]);
        root.left = reBuild02(in, pos, posStart, posStart + lengthOfLeft - 1, inStart, map);
        root.right = reBuild02(in, pos, posStart + lengthOfLeft, posEnd - 1, inRoot + 1, map);
        return root;
    }
}
