package com.leetcode.myCode;

import java.util.ArrayList;
import java.util.List;

public class L442_FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                res.add(Math.abs(nums[i]));
            else
                nums[index] = -nums[index];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(new L442_FindAllDuplicatesinanArray().findDuplicates(nums));
    }
}
