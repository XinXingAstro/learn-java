package com.leetcode.myCode;

import java.util.HashMap;

public class L697_DegreeofanArray {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap(), first = new HashMap(), last = new HashMap();
        int max = 0, f = 0, res = Integer.MAX_VALUE, dis = 0;
        for (int i = 0; i < nums.length; i++) {
            if (first.get(nums[i]) == null)
                first.put(nums[i], i);
            last.put(nums[i], i);
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            f = freq.get(nums[i]);
            if (f > max) max = f;
        }
        for (Integer i : freq.keySet()) {
            if (freq.get(i) == max) {
                dis = last.get(i) - first.get(i) + 1;
                if (dis < res) res = dis;
            }
        }
        return res;
    }

    public int findShortestSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
        }
        int[] freq = new int[max + 1];
        int[] first = new int[max + 1];
        int[] last = new int[max + 1];
        max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (freq[nums[i]] == 0) {
                first[nums[i]] = i;
                last[nums[i]] = i;
            } else
                last[nums[i]] = i;
            freq[nums[i]]++;
            if (freq[nums[i]] > max) max = freq[nums[i]];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (freq[nums[i]] == max)
                res = Math.min(res, last[nums[i]] - first[nums[i]] + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1};
        System.out.println(new L697_DegreeofanArray().findShortestSubArray(nums));
    }
}
