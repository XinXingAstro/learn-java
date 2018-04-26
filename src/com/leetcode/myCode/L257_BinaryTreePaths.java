package com.leetcode.myCode;

import java.util.ArrayList;
import java.util.List;

public class L257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root != null) preorderWalk(root, "", ans);
        return ans;
    }
    public void preorderWalk(TreeNode root, String path, List<String> ans) {
        if (root.left == null && root.right == null) ans.add(path + root.val);
        if (root.left != null) preorderWalk(root.left, path + root.val + "->", ans);
        if (root.right != null) preorderWalk(root.right, path + root.val + "->", ans);
    }
}
