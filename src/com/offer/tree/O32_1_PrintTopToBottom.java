package com.offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印二叉树
 * 算法：层次遍历二叉树
 * 使用队列，每个节点出队前先将其左右子节点入队
 */
public class O32_1_PrintTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        ArrayList<Integer> output = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode pNode = root;
        queue.offer(pNode);
        while (!queue.isEmpty()) {
            pNode = queue.poll();
            output.add(pNode.val);
            if (pNode.left != null) {
                queue.offer(pNode.left);
            }
            if (pNode.right != null) {
                queue.offer(pNode.right);
            }
        }

        return output;
    }
}
