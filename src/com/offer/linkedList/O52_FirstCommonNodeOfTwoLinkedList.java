package com.offer.linkedList;

/**
 * 找到两个单链表的第一个公共节点
 * 算法：
 * 遍历两次链表，第一次得到两个链表的长度，第二次长链表的指针先走几步，然后两个指针一块走，
 * 两个指针会同时指向一个节点，就是这两个链表的第一个公共节点
 */
public class O52_FirstCommonNodeOfTwoLinkedList {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int L1 = 0;
        int L2 = 0;
        while (p1 != null) {
            p1 = p1.next;
            L1++;
        }
        p1 = pHead1;
        while (p2 != null) {
            p2 = p2.next;
            L2++;
        }
        p2 = pHead2;
        if (L1 > L2) {
            for (int i = 0; i < (L1 - L2); i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0; i < (L2 - L1); i++) {
                p2 = p2.next;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
