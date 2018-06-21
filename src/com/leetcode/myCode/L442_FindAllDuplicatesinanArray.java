package com.leetcode.myCode;

import java.util.ArrayList;
import java.util.List;

public class L442_FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] - 1) != i) {
                if (nums[nums[i] - 1] == nums[i] && !res.contains(nums[i]))
                    res.add(nums[i]);
                else {
                    // swap nums[i] nums[nums[i] - 1]
                    int tmp = nums[i];
                    nums[i] = nums[tmp - 1];
                    nums[tmp - 1] = tmp;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(new L442_FindAllDuplicatesinanArray().findDuplicates(nums));
    }
}
