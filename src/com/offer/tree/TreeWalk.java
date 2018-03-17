package com.offer.tree;


import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

/**
 * 二叉树三种遍历方法总结
 */
public class TreeWalk {
    public TreeNode init() {
        TreeNode a0 = new TreeNode(10);
        TreeNode a1 = new TreeNode(6);
        TreeNode a2 = new TreeNode(14);
        TreeNode a3 = new TreeNode(4);
        TreeNode a4 = new TreeNode(8);
        TreeNode a5 = new TreeNode(12);
        TreeNode a6 = new TreeNode(16);

        a0.left = a1;
        a0.right = a2;
        a1.left = a3;
        a1.right = a4;
        a2.left = a5;
        a2.right = a6;

        return a0;
    }

    /**
     *  前序遍历的递归实现
     */
    public void preorderWalk(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderWalk(root.left);
            preorderWalk(root.right);
        }
    }


    public void preorderWalk(TreeLinkNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderWalk(root.left);
            preorderWalk(root.right);
        }
    }

    /**
     * 前序遍历的迭代实现
     */
    public void iterativePreorderWalk(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        if (p != null) {
            stack.push(p);
            while (!stack.empty()) {
                p = stack.pop();
                System.out.print(p.val + " ");
                if (p.right != null) {
                    stack.push(p.right);
                }
                if (p.left != null) {
                    stack.push(p.left);
                }
            }
        }

    }

    /**
     * 中序遍历的递归实现
     */
    public void inorderWalk(TreeNode root) {
        if (root != null) {
            inorderWalk(root.left);
            System.out.print(root.val + " ");
            inorderWalk(root.right);
        }
    }

    public void inorderWalk(TreeLinkNode root) {
        if (root != null) {
            inorderWalk(root.left);
            System.out.print(root.val + " ");
            inorderWalk(root.right);
        }
    }

    /**
     * 中序遍历的迭代实现
     */
    public void iterativeInorderWalk(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while (p != null || stack.size() > 0) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (stack.size() > 0) {
                p = stack.pop();
                System.out.print(p.val + " ");
                p = p.right;
            }
        }
    }

    /**
     * 后续遍历算法递归实现
     */
    public void postorderWalk(TreeNode root) {
        if (root != null) {
            postorderWalk(root.left);
            postorderWalk(root.right);
            System.out.print(root.val + " ");
        }
    }

    /**
     * 后续遍历的迭代实现
     */
    public void iterativePostorderWalk(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> output = new Stack<TreeNode>();
        TreeNode p = root;
        while (p != null || stack.size() > 0) {
            while (p != null) {
                output.push(p);
                stack.push(p);
                p = p.right;
            }
            if (stack.size() > 0) {
                p = stack.pop().left;
            }
        }
        while (output.size() > 0) {
            System.out.print(output.pop().val + " ");
        }
    }

    /**
     * 层次遍历二叉树
     */
    public void levelOrderWalk(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode p = root;
        queue.offer(p);
        while (!queue.isEmpty()) {
            p = queue.poll();
            System.out.print(p.val + " ");
            if (p.left != null) {
                queue.offer(p.left);
            }
            if (p.right != null) {
                queue.offer(p.right);
            }
        }
    }

    public void levelOrderWalk(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        TreeLinkNode p = root;
        queue.offer(p);
        while (!queue.isEmpty()) {
            p = queue.poll();
            System.out.print(p.val + " ");
            if (p.left != null) {
                queue.offer(p.left);
            }
            if (p.right != null) {
                queue.offer(p.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeWalk test = new TreeWalk();
        TreeNode root = test.init();

        test.levelOrderWalk(root);
       /* test.preorderWalk(root);
        System.out.println();
        test.iterativePreorderWalk(root);
        System.out.println();
        test.inorderWalk(root);
        System.out.println();
        test.iterativeInorderWalk(root);
        System.out.println();
        test.postorderWalk(root);
        System.out.println();
        test.iterativePostorderWalk(root);*/
    }
}
