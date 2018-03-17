package com.leetcode.myCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//3Sum 87ms
public class _15 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return res;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            find2Sum(nums, nums[i], i + 1, nums.length - 1);
        }

        return res;
    }
    public void find2Sum(int[] nums, int target, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            if (nums[i] + nums[j] + target == 0) {
                List<Integer> ans = new ArrayList<Integer>();
                ans.add(target);
                ans.add(nums[i]);
                ans.add(nums[j]);
                res.add(ans);
                while (i < j && nums[i] == nums[i + 1]) i++;
                while (i < j && nums[j] == nums[j - 1]) j--;
                i++;
                j--;
            } else if (nums[i] + nums[j] + target < 0) {
                i++;
            } else j--;
        }
    }
    public static void main(String[] args) {
        _15 test = new _15();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(test.threeSum(nums));
    }
}
