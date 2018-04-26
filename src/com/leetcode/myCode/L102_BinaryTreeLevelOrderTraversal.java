package com.leetcode.myCode;

import javax.sound.sampled.LineEvent;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class L102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                tmp.add(p.val);
                if (p.left != null) queue.offer(p.left);
                if (p.right != null) queue.offer(p.right);
            }
            ans.add(tmp);
        }
        return ans;
    }

    public List<List<Integer>> levelOrder02(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        levelOrderWalk(root, 0, ans);
        return ans;
    }
    public void levelOrderWalk(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) return;
        if (level >= ans.size()) ans.add(new ArrayList<>());
        ans.get(level).add(root.val);
        levelOrderWalk(root.left, level+1, ans);
        levelOrderWalk(root.right, level+1, ans);
    }
}
