package com.algorithm;

public class Shellsort {
    public void shellsort(int[] nums) {
        int inc = nums.length >> 1;
        while (inc > 0) {
            for (int i = inc; i <= nums.length-1; i++) {
                int tmp = nums[i];
                int j = i;
                while (j >= inc && nums[j-inc] > tmp) {
                    nums[j] = nums[j-inc];
                    j -= inc;
                }
                nums[j] = tmp;
            }
            inc >>= 1;
        }
    }
}
