package com.leetcode.myCode;



public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reBuild(pre, in, 0, pre.length-1, 0, in.length-1);
    }
    public TreeNode reBuild(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart >= preEnd) {
            return null;
        }
        int inRoot = find(inStart, inEnd, pre[preStart], in);
        int lengthOfLeft = inRoot - inStart;
        //int rightRoot = preStart + 1; //左子树根节点在pre序列中的位置
        //int leftRoot = preStart + lengthOfLeft + 1; //右子树根节点在pre序列中的位置
        TreeNode root = new TreeNode(pre[preStart]);
        root.left = reBuild(pre, in, preStart+1, preStart+lengthOfLeft, inRoot-lengthOfLeft, inRoot-1);
        root.right = reBuild(pre, in, preStart+lengthOfLeft+1, preEnd, inRoot+1, inEnd);
        return root;
    }
    public int find(int start, int end, int val, int[] in) {
        for (int i = start; i <= end; i++) {
            if (val == in[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};
        s.reConstructBinaryTree(pre, in);
    }
}
