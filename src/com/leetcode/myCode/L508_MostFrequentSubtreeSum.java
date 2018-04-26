package com.leetcode.myCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L508_MostFrequentSubtreeSum {
    //HashMap中key代表sum值，value是该sum出现的次数
    private Map<Integer, Integer> map = new HashMap<>();
    private int maxCount = Integer.MIN_VALUE;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        getSum(root);
        List<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == maxCount) list.add(key);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) ans[i] = list.get(i);
        return ans;
    }
    public int getSum(TreeNode root) {
        if (root == null) return 0;
        int left = getSum(root.left);
        int right = getSum(root.right);
        int sum = left + right + root.val;
        if (map.get(sum) == null) map.put(sum, 1);
        map.put(sum, map.get(sum) + 1);
        if (map.get(sum) > maxCount) maxCount = map.get(sum);
        return sum;
    }

    public static void main(String[] args) {
        L508_MostFrequentSubtreeSum test = new L508_MostFrequentSubtreeSum();
        test.findFrequentTreeSum(TreeNode.initTree03());
    }
}
