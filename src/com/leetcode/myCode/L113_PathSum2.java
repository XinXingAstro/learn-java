package com.leetcode.myCode;

import java.util.*;

public class L113_PathSum2 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();
        preorderWalk(root, 0, sum, new ArrayList<>());
        return ans;
    }
    public void preorderWalk(TreeNode root, int pathSum, int sum, ArrayList<Integer> list) {
        if (root == null) return;
        pathSum += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null && pathSum == sum) ans.add(new ArrayList<>(list));
        preorderWalk(root.left, pathSum, sum, list);
        preorderWalk(root.right, pathSum, sum, list);
        pathSum -= root.val;
        list.remove(list.size() - 1);
    }
}
