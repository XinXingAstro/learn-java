package com.leetcode.myCode;

import java.util.ArrayList;
import java.util.List;

public class L501_FindModeinBinarySearchTree {
    //解该题最重要的一点是要知道，如果搜索二叉树中存在重复元素，这该树的中序遍历序列中，相同元素肯定都在一块儿
    private int curNodeVal;
    private int curNodeCount = 0;
    private int maxCount = 1;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        ArrayList<Integer> modeList = new ArrayList<>();
        inorderWalk(root, modeList);
        int[] modes = new int[modeList.size()];
        for (int i = 0; i < modeList.size(); i++) modes[i] = modeList.get(i);
        return modes;
    }
    private void inorderWalk(TreeNode root, ArrayList<Integer> modeList) {
        if (root == null) return;
        inorderWalk(root.left, modeList);
        if (root.val == curNodeVal) {
            curNodeCount++;
        } else {
            curNodeVal = root.val;
            curNodeCount = 1;
        }
        if (curNodeCount == maxCount) {
            modeList.add(curNodeVal);
        }
        if (curNodeCount > maxCount) {
            maxCount = curNodeCount;
            modeList.clear();
            modeList.add(curNodeVal);
        }
        inorderWalk(root.right, modeList);
    }
}
