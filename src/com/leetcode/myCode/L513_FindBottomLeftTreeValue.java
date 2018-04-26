package com.leetcode.myCode;

import java.util.ArrayDeque;

public class L513_FindBottomLeftTreeValue {
    //算法1：利用层次遍历找左下角元素
    public int findBottomLeftValue(TreeNode root) {
        // if (root == null) return null;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        TreeNode p = root;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                if (p.right != null) queue.offer(p.right);
                if (p.left != null) queue.offer(p.left);
            }
        }
        return p.val;
    }

    //算法2：利用前序遍历找每次进入新层以后记录第一个元素
    private int newLevel;
    private int ans;
    public int findBottomLeftValue01(TreeNode root) {
        preorderWalk(root, 0);
        return ans;
    }
    public void preorderWalk(TreeNode root, int level) {
        if (root == null) return;
        if (newLevel == level) {
            newLevel++;
            ans = root.val;
        }
        preorderWalk(root.left, level+1);
        preorderWalk(root.right, level+1);
    }
}
