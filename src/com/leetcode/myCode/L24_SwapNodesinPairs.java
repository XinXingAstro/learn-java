package com.leetcode.myCode;

public class L24_SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null) {
            ListNode pos = cur.next;
            cur.next = pos.next;
            pos.next = pos.next.next;
            cur.next.next = pos;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
