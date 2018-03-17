package com.leetcode.myCode;

public class _560 {
    public int subarraySum(int[] nums, int k) {
        int matchNums = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) matchNums++;
            }
        }

        return matchNums;
    }
    public static void main(String[] args) {
        _560 test = new _560();
        int[] nums = {-1,-1,1};
        int k = 0;
        System.out.println(test.subarraySum(nums, k));

    }
}
