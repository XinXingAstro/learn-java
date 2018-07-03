package com.leetcode.myCode;

public class L217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];
        }
        int[] map = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            if (map[nums[i] - min] != 0) return true;
            else map[nums[i] - min]++;
        }
        return false;
    }
}
