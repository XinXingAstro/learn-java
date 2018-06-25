package com.leetcode.myCode;

public class L540_SingleElementinaSortedArray {
    public int singleNonDuplicate(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }
    public int binarySearch(int[] nums, int start, int end) {
        if (start >= end)
            return nums[start];

        int mid = (start + end) >> 1;
        if ((mid & 1) == 1) mid--;
        if (nums[mid] != nums[mid + 1])
            return binarySearch(nums, start, mid); // 这里end设为mid是防止mid正好指向出现一次的元素的情况
        else
            return binarySearch(nums, mid + 2, end);

    }

    public int singleNonDuplicate1(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(start < end) {
            int mid = (start + end) >> 1;
            if ((mid & 1) == 1) mid--;
            if (nums[mid] != nums[mid + 1])
                end = mid;
            else
                start = mid + 2;
        }
        return nums[start];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(new L540_SingleElementinaSortedArray().singleNonDuplicate1(nums));
    }
}
