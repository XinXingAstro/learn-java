package com.leetcode.myCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L515_FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                if (p.val > max) max = p.val;
                if (p.left != null) queue.offer(p.left);
                if (p.right != null) queue.offer(p.right);
            }
            ans.add(max);
        }
        return ans;
    }
}
