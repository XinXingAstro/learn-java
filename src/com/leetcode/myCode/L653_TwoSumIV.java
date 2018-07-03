package com.leetcode.myCode;

import java.util.ArrayList;

public class L653_TwoSumIV {
    private ArrayList<Integer> keyMap = new ArrayList();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        getKey(root);
        int size = keyMap.size();
        int l = 0, r = size - 1, sum = 0;
        while (l < r) {
            sum = keyMap.get(l) + keyMap.get(r);
            if (sum > k) r--;
            else if (sum < k) l++;
            else return true;
        }
        return false;
    }
    public void getKey(TreeNode root) {
        if (root == null) return;
        getKey(root.left);
        keyMap.add(root.val);
        getKey(root.right);
    }
}
