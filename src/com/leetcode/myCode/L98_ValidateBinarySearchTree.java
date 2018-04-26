package com.leetcode.myCode;

import java.util.ArrayList;

public class L98_ValidateBinarySearchTree {
    ArrayList<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        inorderWalk(root);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            if (list.get(i-1) >= list.get(i)) return false;
        }
        return true;
    }
    public void inorderWalk(TreeNode root) {
        if (root == null) return;
        inorderWalk(root.left);
        list.add(root.val);
        inorderWalk(root.right);
    }

    public boolean isValidBST02(TreeNode root) {
        //这里必须是Long类型，测试用例里有大数节点
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    public static void main(String[] args) {
        L98_ValidateBinarySearchTree test = new L98_ValidateBinarySearchTree();
        test.isValidBST(TreeNode.initTree());
    }
}
