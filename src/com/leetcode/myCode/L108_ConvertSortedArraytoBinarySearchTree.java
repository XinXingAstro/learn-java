package com.leetcode.myCode;

public class L108_ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0 || nums == null) return null;
        return buildBST(nums, 0, nums.length-1);
    }
    public TreeNode buildBST(int[] nodes, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(nodes[mid]);
        root.left = buildBST(nodes, start, mid-1);
        root.right = buildBST(nodes, mid+1, end);
        return root;
    }
}
