package com.leetcode.myCode;

public class L53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int size = nums.length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
            if (sum > maxSum) maxSum = sum;
            if (sum < 0) sum = 0;
        }
        return maxSum;
    }
}
