package com.leetcode.myCode;


import java.util.Arrays;

public class _581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] copyNums = nums.clone();
        int first = 0, end = 0;
        Arrays.sort(copyNums);
        for (int i = 0; i < nums.length; i++) {
            if (copyNums[i] != nums[i]) {
                first = i;
                break;
            }
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            if (copyNums[j] != nums[j]) {
                end = j;
                break;
            }
        }
        return (end == 0 && first == 0) ? 0 : end - first + 1;
    }

    public static void main(String[] args) {
        _581 test = new _581();
        int[] nums = {1, 2, 3, 7, 6, 5, 7, 8, 9};

        System.out.println(test.findUnsortedSubarray(nums));
    }
}
