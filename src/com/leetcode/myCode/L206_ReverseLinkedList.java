package com.leetcode.myCode;

public class L206_ReverseLinkedList {
    /**
     * 翻转单链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pos = null;
        ListNode cur = head;
        ListNode pre = head.next;
        while (pre != null) {
            cur.next = pos;
            pos = cur;
            cur = pre;
            pre = pre.next;
        }
        cur.next = pos;
        return cur;
    }
}
