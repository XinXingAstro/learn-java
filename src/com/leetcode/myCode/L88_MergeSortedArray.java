package com.leetcode.myCode;

/**
 * 从后向前合并两个排序数组
 * 该算法和O5使用的算法一样
 *
 */
public class L88_MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }

        for(int a : nums1) {
            System.out.print(a + " ");
        }
    }

    public static void main(String[] args) {
        int[] a1 = new int[10];
        int j = 1;
        for (int i = 0; i < 5; i++) {
            a1[i] = j;
            j+=2;
        }
        int[] a2 = {2,4,6,8,10};
        merge(a1,5, a2, 5);
    }
}
