package com.offer.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 之子型打印二叉树
 * 算法：设置两个栈stack1，stack2，stack1先压入根节点，stack1弹出根节点时，stack2压入根节点的
 * 左子节点，然后压入根节点的右子节点，stack1为空时，弹出stack2的节点，stack2弹出一个节点，stack1
 * 存储该节点的右子节点，然后存该节点的左子节点（两栈压入左右子节点的顺序相反），当两个栈都为空时
 * 算法结束。
 */
public class O32_3_ZhiPrintTree {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<ArrayList<Integer>>();
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        TreeNode pNode = null;
        stack1.push(pRoot);
        while (!stack1.empty() || !stack2.empty()) {
            if (!stack1.empty()) {
                ArrayList<Integer> a = new ArrayList<Integer>();
                while (!stack1.empty()) {
                    a.add(stack1.peek().val);
                    pNode = stack1.pop();
                    if (pNode.left != null) {
                        stack2.push(pNode.left);
                    }
                    if (pNode.right != null) {
                        stack2.push(pNode.right);
                    }
                }
                output.add(a);
            }

            if (!stack2.empty()) {
                ArrayList<Integer> b = new ArrayList<Integer>();
                while(!stack2.empty()) {
                    b.add(stack2.peek().val);
                    pNode = stack2.pop();
                    if (pNode.right != null) {
                        stack1.push(pNode.right);
                    }
                    if (pNode.left != null) {
                        stack1.push(pNode.left);
                    }
                }
                output.add(b);
            }
        }
        return output;
    }
}
