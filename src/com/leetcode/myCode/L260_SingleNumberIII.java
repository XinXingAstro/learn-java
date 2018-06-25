package com.leetcode.myCode;

public class L260_SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int div = 1;
        for (int i = 0; i < 32; i++) {
            if ((div & xor) != 0)
                break;
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((div & nums[i]) != 0)
                a ^= nums[i];
            else
                b ^= nums[i];
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        System.out.println(new L260_SingleNumberIII().singleNumber(nums));
    }
}
