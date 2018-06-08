package com.leetcode.myCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, ans, new ArrayList<Integer>());
        return ans;
    }
    public void helper(int[] candidates, int target, int start, List<List<Integer>> ans, ArrayList<Integer> cur) {
        if (target == 0) ans.add(new ArrayList<>(cur));
        else if (target > 0) {
            for (int i = start; i <= candidates.length - 1 && target >= candidates[i]; i++) {
                cur.add(candidates[i]);
                helper(candidates, target - candidates[i], i, ans, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        L39_CombinationSum test = new L39_CombinationSum();
        int[] a = {2,3,5};
        System.out.println(test.combinationSum(a, 8));
    }
}
