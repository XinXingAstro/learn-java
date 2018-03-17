package com.leetcode.myCode;

public class _55 {
    public boolean canJump(int[] nums) {
        int i = 0;
        int maxRange = nums[i];
        while (i + maxRange < nums.length - 1) {
            if (maxRange == 0) return false;
            else {
                if (maxRange == 1 && nums[i + 1] == 0 && i + 1 < nums.length - 1) return false;
                int max = nums[i] + i; //记录maxRange范围内的最大值
                int maxIndex = i; // 记录maxRange范围内最大值的index
                for (int j = i + 1; j <= i + maxRange; j++) {
                    if (nums[j] + j >= max) {
                        max = nums[j] + j;
                        maxIndex = j;
                    }
                }
                i = maxIndex; //跳到最大值处
                maxRange = nums[i];
                if (i + maxRange >= nums.length - 1) return true;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        _55 test = new _55();
        int[] a = {3,2,1,0,4};
        System.out.println(test.canJump(a));
    }
}
