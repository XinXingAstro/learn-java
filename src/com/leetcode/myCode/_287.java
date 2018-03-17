package com.leetcode.myCode;

public class _287 {
    public int findDuplicate(int[] nums) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != (i + 1)) {
                if (nums[nums[i] - 1] == nums[i]) break;
                else {
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                    i--;
                }
            }
        }
        return nums[i];
    }
    public static void main(String[] args) {
        _287 test = new _287();
        int[] nums = {8,7,1,10,17,15,18,11,16,9,19,12,5,14,3,4,2,13,18,18};
        System.out.println(test.findDuplicate(nums));
    }
}
