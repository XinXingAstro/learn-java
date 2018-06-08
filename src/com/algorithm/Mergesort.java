package com.algorithm;

public class Mergesort {
    /**
     * 自顶向下的排序算法
     * @param nums
     * @param start
     * @param end
     */
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

    private static Comparable[] aux; //归并排序的辅助数组
    /**
     * 自第向上的排序算法
     * @param nums
     */
    public void mergesort1(Comparable[] nums) {
        // 需要进行logN次两两归并
        int len = nums.length;
        aux = new Comparable[len];
        for (int size = 1; size < len; size <<= 1) { //size表示子数组长度
            for (int start = 0; start < len - size; start += (size<<1)) {
                merge1(nums, start, start + size - 1, Math.min(start + size + size - 1, len - 1));
            }
        }
    }
    public void merge1(Comparable[] nums, int start, int mid, int end) {
        //将nums[start~mid]和nums[mid+1~hi]归并
        int i = start, j = mid + 1;
        for (int k = start; k <= end; k++) {
            aux[k] = nums[k]; //将nums[start~end]复制到aux[start~end]
        }
        for (int k = start; k <= end; k++) {
            if (i > mid) nums[k] = aux[j++];
            else if (j > end) nums[k] = aux[i++];
            else if (aux[j].compareTo(aux[i]) < 0) nums[k] = aux[j++];
            else nums[k] = aux[i++];
        }
    }
}
