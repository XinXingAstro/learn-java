package com.leetcode.myCode;

/**
 * 对链表排序
 * 这里使用归并排序算法
 */
public class L148_SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow;
        pre.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(fast);
        return merge(l1, l2);
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(Integer.MIN_VALUE);
        // if (l1.val < l2.val) {
        //     head = l1;
        //     l1 = l1.next;
        // } else {
        //     head = l2;
        //     l2 = l2.next;
        // }
        ListNode pNode = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pNode.next = l1;
                pNode = pNode.next;
                l1 = l1.next;
            } else {
                pNode.next = l2;
                pNode = pNode.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) pNode.next = l1;
        if (l2 != null) pNode.next = l2;
        return head.next;
    }

    public static void main(String[] args) {
        L148_SortList test = new L148_SortList();
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        test.sortList(a);
    }
}
