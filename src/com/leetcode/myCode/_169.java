package com.leetcode.myCode;

import java.util.HashMap;
import java.util.Map;

public class _169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int majr = 0;
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (hm.get(nums[i]) == null) hm.put(nums[i], 1);
            else hm.put(nums[i], hm.get(nums[i]) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() > times) {
                majr = entry.getKey();
                times = entry.getValue();
            }
        }
        return majr;
    }

    public static void main(String[] args) {
        _169 test = new _169();
        int[] nums = {1, 0, 0, 1, 0, 1, 1, 1};

        System.out.println(test.majorityElement(nums));
    }

}
