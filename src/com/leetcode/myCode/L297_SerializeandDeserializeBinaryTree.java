package com.leetcode.myCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L297_SerializeandDeserializeBinaryTree {
    private static final String NULL = "X";
    private static final String SPLITOR = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorderWalk(root, sb);
        return sb.toString();
    }
    private void preorderWalk(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SPLITOR);
            return;
        }
        sb.append(root.val).append(SPLITOR);
        preorderWalk(root.left, sb);
        preorderWalk(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(SPLITOR)));
        return build(queue);
    }
    private TreeNode build(Queue<String> queue) {
        String p = queue.poll();
        if (p.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(p));
        root.left = build(queue);
        root.right = build(queue);
        return root;
    }
}
