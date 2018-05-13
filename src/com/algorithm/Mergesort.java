package com.algorithm;

public class Mergesort {
    public void mergesort(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) >> 1;
        mergesort(nums, start, mid);
        mergesort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }
    public void merge(int[] nums, int start, int mid, int end) {
        int len1 = mid - start + 1;
        int len2 = end - mid;
        int[] L = new int[len1 + 1];
        int[] R = new int[len2 + 1];
        for (int i = start, j = 0 ; i <= mid; i++) {
            L[j++] = nums[i];
        }
        L[len1] = Integer.MAX_VALUE;
        for (int i = mid + 1, j = 0; i <= end; i++) {
            R[j++] = nums[i];
        }
        R[len2] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int k = start; k <= end; k++) {
            if (L[i] <= R[j]) {
                nums[k] = L[i++];
            } else {
                nums[k] = R[j++];
            }
        }
    }
}
