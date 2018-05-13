package com.algorithm;

public class Selectionsort {
    public void selectionsort(int[] nums) {
        int max = 0;
        for (int i = nums.length-1; i >= 1; i--) {
            max = 0;
            for (int j = 0; j <= i; j++) {
                if (nums[j] > nums[max]) {
                    max = j;
                }
            }
            swap(nums, i, max);
        }
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
