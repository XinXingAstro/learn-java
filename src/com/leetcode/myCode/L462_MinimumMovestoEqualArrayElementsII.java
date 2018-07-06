package com.leetcode.myCode;

import java.util.Arrays;

public class L462_MinimumMovestoEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, res = 0;
        while (i < j) {
            res += nums[j--] - nums[i++];
        }
        return res;
    }
}
