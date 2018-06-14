package com.leetcode.myCode;

public class L215_KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1)
            return nums[0];
        int target = nums.length - k;
        int left = 0, right = nums.length - 1;
        int index = partition(nums, left, right);
        while (index != target) {
            if (target > index) {
                left = index + 1;
                index = partition(nums, left, right);
            } else {
                right = index - 1;
                index = partition(nums, left, right);
            }
        }
        return nums[index];
    }
    public int partition(int[] nums, int start, int end) {
        if (start >= end)
            return start;
        // int mid = (start + end) >> 1;
        int mid = start + (int)(Math.random() * (end - start));
        swap(nums, mid, end);
        int x = nums[end];
        int small = start - 1;
        for (int i = start; i <= end - 1; i++) {
            if (nums[i] < x){
                swap(nums, i, ++small);
            }
        }
        swap(nums, ++small, end);
        return small;
    }
    public void swap(int[] nums, int a, int b) {
        if (a == b) return;
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
        L215_KthLargestElementinanArray test = new L215_KthLargestElementinanArray();
        System.out.println(test.findKthLargest(a, 20));
    }
}
