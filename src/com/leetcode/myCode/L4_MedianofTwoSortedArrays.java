package com.leetcode.myCode;

public class L4_MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = (nums1.length + nums2.length + 1) / 2;
        int r = (nums1.length + nums2.length + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, l) + findKth(nums1, 0, nums2, 0, r)) / 2.0;
    }

    public double findKth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart >= A.length) return B[bStart + k - 1];
        if (bStart >= B.length) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE;
        int bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1];
        if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];

        if (aMid < bMid) {
            return findKth(A, aStart + k/2, B, bStart, k - k/2);
        } else {
            return findKth(A, aStart, B, bStart + k/2, k - k/2);
        }
    }
}
