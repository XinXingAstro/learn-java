package com.offer.tree;

/**
 * 将搜索二叉树转换为一个排序的双向链表
 * 算法：由于搜索二叉树的中序遍历序列是从小到大排序的，所以算法要基于二叉树的中序遍历算法写
 * I.如果当前节点的左子树不为空，则转换左子树为排序双向链表
 * II.将当前节点和链表最后一个节点连接起来，则当前节点成为链表最后一个节点
 * III.如果当前节点右子树不为空，则转换右子树为排序双向链表
 * 注意：实际的链表创建和连接的工作都在步骤II中完成，I和III是递归过程
 *
 */
public class O36_ConvertTreeToLinkedList {
    TreeNode lastNode = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        convertCore(pRootOfTree);
        TreeNode head = lastNode;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }

    public void convertCore(TreeNode pNode) {
        if (pNode == null) {
            return;
        }

        convertCore(pNode.left);

        pNode.left = lastNode;
        if (lastNode != null) {
            lastNode.right = pNode;
        }
        lastNode = pNode;

        convertCore(pNode.right);
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(8);
        TreeNode a2 = new TreeNode(6);
        TreeNode a3 = new TreeNode(4);
        TreeNode a4 = new TreeNode(7);
        TreeNode a5 = new TreeNode(9);
        a1.left = a2;
        a1.right = a5;
        a2.left = a3;
        a2.right = a4;
        O36_ConvertTreeToLinkedList test = new O36_ConvertTreeToLinkedList();
        TreeNode head = test.Convert(a1);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }
    }
}
