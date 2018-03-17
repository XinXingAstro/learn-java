package com.offer.tree;

import java.util.ArrayList;

/**
 * 输入一个二叉树，和一个整数，输出二叉树中节点值的和等于该值的所有路径
 * 路径：从根节点开始，叶子节点结束
 * 算法：由于路径是从根节点开始，所以用前序遍历遍历整个二叉树，同时存储路过的节点，
 * 当遍历到叶子节点是，就得到两一个完整的路径，计算节点值的和，如果和给出值相等，
 * 则返回这条路径，如果不等，则返回父节点继续遍历。基于前序遍历，在遍历的过程中，
 * 一边存储路径，一边计算路径节点值的和。
 */
public class O34_PathInTree {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<ArrayList<Integer>>();
        }

        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        findPathCore(root, target, 0, path, output);

        return output;
    }

    public void findPathCore(TreeNode pNode, int target, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> output) {
        sum += pNode.val;
        path.add(pNode.val);

        // 如果该节点为叶子节点，并且路径值=target
        if (pNode.left == null && pNode.right == null && sum == target) {
            output.add((ArrayList<Integer>)path.clone());
            path.remove(path.size() - 1);
            return;
        }

        // 若不是叶子节点则继续遍历
        if (pNode.left != null) {
            findPathCore(pNode.left, target, sum, path, output);
        }
        if (pNode.right != null) {
            findPathCore(pNode.right, target, sum, path, output);
        }

        // 若是叶子节点但路径和不等于target，则在路径中减去该节点
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(10);
        TreeNode a2 = new TreeNode(5);
        TreeNode a3 = new TreeNode(12);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(7);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;

        O34_PathInTree test = new O34_PathInTree();
        test.FindPath(a1, 22);
        
    }
}
