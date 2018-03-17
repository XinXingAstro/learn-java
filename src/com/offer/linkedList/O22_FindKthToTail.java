package com.offer.linkedList;

/**
 * 找到链表倒数第K个节点
 * 注意3中情况
 * 1）链表为null；
 * 2）k = 0；
 * 3）k大于链表长度
 */
public class O22_FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = null;

        for (int i = 0; i < (k - 1); i++) {
            if (p1.next != null) {
                p1 = p1.next;
            } else {
                return null;
            }
        }
        p2 = head;
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }
}
