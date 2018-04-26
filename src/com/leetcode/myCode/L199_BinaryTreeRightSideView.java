package com.leetcode.myCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class L199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans.add(queue.peek().val);
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                if (p.right != null) queue.offer(p.right);
                if (p.left != null) queue.offer(p.left);
            }
        }
        return ans;
    }

    public List<Integer> rightSideView02(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        levelWalk(root, ans, 0);
        return ans;
    }
    public void levelWalk(TreeNode root, ArrayList<Integer> ans, int depth) {
        if (root == null) return;
        if (depth == ans.size()) ans.add(root.val);
        levelWalk(root.right, ans, depth+1);
        levelWalk(root.left, ans, depth+1);

    }
}
