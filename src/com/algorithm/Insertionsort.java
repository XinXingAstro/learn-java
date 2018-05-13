package com.algorithm;

public class Insertionsort {
    public void insertionsort(int[] nums) {
        for (int i = 1; i <= nums.length-1; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
    }
}
