package com.leetcode.myCode;

import java.util.*;

public class L107_BinaryTreeLevelOrderTraversal2 {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> ans = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pNode = queue.poll();
                if (pNode.left != null) queue.offer(pNode.left);
                if (pNode.right != null) queue.offer(pNode.right);
                level.add(pNode.val);
            }
            ans.add(0, level);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.print(levelOrderBottom(TreeNode.initTree()));
    }
}
