package com.offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 分层输出二叉树
 * 算法：设置两个变量pLevel, nextLevel
 * pLevel：代表当前层代输出节点数
 * nextLevel：代表下一城待输出节点数
 */
public class O32_2_PrintTreeInLevel {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<ArrayList<Integer>>();
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        TreeNode pNode = null;
        queue.offer(pRoot);
        int pLevel = 1;
        int nextLevel = 0;
        while (!queue.isEmpty()) {
            a.add(queue.peek().val);
            pNode = queue.pop();
            pLevel--;
            if (pNode.left != null) {
                queue.offer(pNode.left);
                nextLevel++;
            }
            if (pNode.right != null) {
                queue.offer(pNode.right);
                nextLevel++;
            }
            if (pLevel == 0) {
                pLevel = nextLevel;
                nextLevel = 0;
                output.add(a);
                a = new ArrayList<Integer>();
            }
        }
        return output;
    }
}
