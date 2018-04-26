package com.leetcode.myCode;

public class L230_KthSmallestElementinaBST {
    public int count = 0;
    public int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        if (root != null) inorderWalk(root);
        return ans;
    }
    public void inorderWalk(TreeNode root) {
        if (root == null) return;
        inorderWalk(root.left);
        count--;
        if (count == 0) {
            ans = root.val;
            return;
        }
        inorderWalk(root.right);
    }
}
