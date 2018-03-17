package com.offer.tree;

import java.util.ArrayList;

/**
 * 输入一颗二叉树，判断该树是不是平衡二叉树
 * 平衡二叉树：如果树中任意节点的左、右子树的深度相差不超过1，那么它就是一颗平衡二叉树
 *
 */
public class O55_2_IsBalanceTree {
    public class Depth {
        public int depth;
        public void setDepth(int value) {
            this.depth = value;
        }
        public int getDepth() {
            return this.depth;
        }
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        return isBalanced(root, new Depth());
    }
    public boolean isBalanced(TreeNode pNode, Depth depth) {
        if (pNode == null) {
            depth.setDepth(0);
            return true;
        }

        Depth left = new Depth();
        Depth right = new Depth();
        if (isBalanced(pNode.left, left) && isBalanced(pNode.right, right)) {
            int diff = left.getDepth() - right.getDepth();
            if (diff <= 1 && diff >= -1) {
                int t = (left.getDepth() > right.getDepth() ? (left.getDepth() + 1) : (right.getDepth() + 1));
                depth.setDepth(t);
                return true;
            }
        }

        return false;
    }
}
