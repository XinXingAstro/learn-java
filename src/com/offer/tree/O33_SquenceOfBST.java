package com.offer.tree;

/**
 * 判断一个序列是否是二叉搜索树的后序遍历序列
 * 算法：二叉搜索树的后序遍历序列中，左右一个节点是根节点，
 * BST左子树所有节点的值小于根节点的值
 * BST右子树所有节点的值大于根节点的值
 * 如果在序列中发现右子树的值有小于根节点的值，则不是二叉搜索树的后序遍历序列
 */
public class O33_SquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        return isSquence(sequence, 0, sequence.length - 1);
    }

    public boolean isSquence(int[] seq, int start, int end) {
        if (seq == null || seq.length == 0) {
            return false;
        }
        if (end - start <= 1) {
            return true;
        }
        int mid = start;
        while (mid <= end) {
            // 这里的等于号'='非常重要，和根节点相等的情况应该归属于右子树，
            // 这样每次递归，子树节点个数才会减少，如果归属于左子树，则左子树节点
            // 和数永远不会减少，最终会造成栈溢出。
            if (seq[mid] >= seq[end]) {
                break;
            }
            mid++;
        }
        for (int i = mid; i <= end; i++) {
            if (seq[i] < seq[end]) {
                return false;
            }
        }

        return isSquence(seq, start, mid - 1) && isSquence(seq, mid, end - 1);
    }

    public static void main(String[] args) {
        O33_SquenceOfBST test = new O33_SquenceOfBST();
        int[] seq = {};
        System.out.print(test.VerifySquenceOfBST(seq));
    }
}
