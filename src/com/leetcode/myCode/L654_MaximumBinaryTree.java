package com.leetcode.myCode;

public class L654_MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return build(nums, 0, nums.length-1);
    }
    public TreeNode build(int[] nums, int start, int end) {
        if (start > end)
            return null;
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = build(nums, start, index - 1);
        root.right = build(nums, index + 1, end);
        return root;
    }
}
