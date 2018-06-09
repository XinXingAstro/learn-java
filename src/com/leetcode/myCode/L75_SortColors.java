package com.leetcode.myCode;

public class L75_SortColors {
    /**
     * 三向切分法对数组排序
     * @param nums
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int lt = -1;
        int gt = nums.length;
        int i = 0;
        while (i < gt) {
            if (nums[i] == 0) {
                lt++;
                swap(nums, i, lt);
                // 防止i指针进入lt的左边
                if (lt == i) i++;
            } else if (nums[i] == 2) {
                gt--;
                swap(nums, i, gt);
            } else i++;
        }
    }
    public void swap(int[] nums, int a, int b) {
        if (a == b) return;
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
