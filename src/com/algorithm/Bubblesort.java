package com.algorithm;

public class Bubblesort {
    public void bubblesort(int[] nums) {
        for (int i = nums.length-1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j+1]) {
                    swap(nums, j, j+1);
                }
            }
        }
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void bubblesort1(int[] nums) {
        int flag = 0;
        for (int i = nums.length-1; i >= 1; i--) {
            flag = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j+1]) {
                    swap(nums, j, j+1);
                    flag = j+1;
                }
            }
            i = flag;
        }
    }
}
