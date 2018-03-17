package com.leetcode.myCode;

public class _34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1, -1};

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                int n = m;
                int start = m;
                int end = m;
                while (n > 0 && nums[n - 1] == nums[start]) {
                    start = n - 1;
                    n--;
                }
                n = m;
                while (n < nums.length - 1 && nums[n + 1] == nums[end]) {
                    end = n + 1;
                    n++;
                }
                return new int[]{start, end};
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        _34 test = new _34();
        int[] nums = {};
        int target = 5;
        int[] ans = test.searchRange(nums, target);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
