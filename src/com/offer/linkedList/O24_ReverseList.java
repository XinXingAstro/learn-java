package com.offer.linkedList;

/**
 * 翻转链表
 * 算法：用三个指针反转每一个节点，有点像删除链表重复节点
 * 注意代码鲁棒性
 */
public class O24_ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pNode = head;
        ListNode pre = null;
        ListNode next = null;
        while (pNode.next != null) {
            next = pNode.next;
            pNode.next = pre;
            pre = pNode;
            pNode = next;
        }
        pNode.next = pre;
        return pNode;
    }

    public static void main(String[] args) {
        O24_ReverseList test = new O24_ReverseList();
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        ListNode root = test.reverseList(a1);
        while (root != null) {
            System.out.print(root.val);
            root = root.next;
        }
    }
}
