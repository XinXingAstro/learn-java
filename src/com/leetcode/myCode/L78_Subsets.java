package com.leetcode.myCode;

import java.util.ArrayList;
import java.util.List;

public class L78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        res.add(new ArrayList<>());
        for (int n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                ArrayList<Integer> tmp = new ArrayList<>(res.get(i));
                tmp.add(n);
                res.add(tmp);
            }
        }
        return res;
    }
}
