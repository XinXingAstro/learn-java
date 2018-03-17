package com.leetcode.myCode;

import java.util.Arrays;

public class _31 {
    public void nextPermutation(int[] nums) {
        int i;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        Arrays.sort(nums, i + 1, nums.length); //fromIndex是排序开始元素的下标，toIndex是排序结束元素的下标+1；
                        break;
                    }
                }
                break;
            }
        }
        if (i == -1) Arrays.sort(nums);
    }
    public static void main(String[] args) {
        _31 test = new _31();
        int[] nums = {1,3,2};
        test.nextPermutation(nums);
        System.out.println("" + nums[0] + nums[1] + nums[2]);
    }
}
