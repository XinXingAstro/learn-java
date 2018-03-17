package com.learn.testClasses;



import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> numbers = new ArrayList<Integer>();

//    public boolean findTarget(TreeNode root, int k) {
//    }

    public void search(TreeNode tnode) {
        if (tnode.left != null) {
            search(tnode.left);
        }

        numbers.add(tnode.val);

        if (tnode.right != null) {
            search(tnode.right);
        }
    }

    public static TreeNode init() {
        TreeNode A = new TreeNode(2, null, null);
        TreeNode B = new TreeNode(4, null, null);
//        TreeNode C = new TreeNode(7, null, null);
        TreeNode D = new TreeNode(3, A, B);
//        TreeNode E = new TreeNode(6, null, C);
//        TreeNode F = new TreeNode(5, D, E);

        return D;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.search(s.init());
        System.out.println(numbers.size());
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}