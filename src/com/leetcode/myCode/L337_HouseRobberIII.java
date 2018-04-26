package com.leetcode.myCode;

import java.util.ArrayDeque;
import java.util.ArrayList;

//还没有解决待解
public class L337_HouseRobberIII {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> sums = new ArrayList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                sum += p.val;
                if (p.left != null) queue.offer(p.left);
                if (p.right != null) queue.offer(p.right);
            }
            sums.add(sum);
        }
        return 0;
    }
}
