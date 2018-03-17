package com.leetcode.myCode;

import java.util.ArrayList;
import java.util.List;

public class _46 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        permutation(nums, 0);
        return ans;
    }
    public void permutation(int[] nums, int start) {
        if (start == nums.length - 1) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            ans.add(list);
        }
        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i] != nums[start]) {
                swap(nums, i, start);
                permutation(nums, start + 1);
                swap(nums, i, start);
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        if (nums[i] != nums[j]){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    public static void main(String[] args) {
        _46 test = new _46();
        int[] nums = {1,2,3};
        List<List<Integer>> ans = test.permute(nums);
        for (List<Integer> n : ans) {
            System.out.println(n);
        }
    }
}
