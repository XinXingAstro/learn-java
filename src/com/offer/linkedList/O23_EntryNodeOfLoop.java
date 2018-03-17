package com.offer.linkedList;

/**
 * 找到链表环的入口节点
 * 算法1：先得到环中节点数，再找入口节点
 * 算法2：龟兔赛跑算法
 */
public class O23_EntryNodeOfLoop {

    /**
     * 算法1
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop_1(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        ListNode p1 = pHead;
        ListNode p2 = pHead;

        while (p1 != null && p2 != null) {
            p1 = p1.next;
            if (p1 != null) {
                p1 = p1.next;
            }
            p2 = p2.next;

            if (p1 == p2) {
                break;
            }
        }
        if (p1 == null || p2 == null) {
            return null;
        }

        p1 = p1.next;
        int count = 1;
        while (p1 != p2) {
            p1 = p1.next;
            count++;
        }

        p1 = pHead;
        p2 = pHead;
        for (int i = 0; i < count; i++) {
            p1 = p1.next;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    /**
     * 算法2：龟兔赛跑
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop_2(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        ListNode p1 = pHead;
        ListNode p2 = pHead;

        while (p1 != null && p2 != null) {
            p1 = p1.next;
            if (p1 != null) {
                p1 = p1.next;
            }
            p2 = p2.next;

            if (p1 == p2) {
                break;
            }
        }
        if (p1 == null || p2 == null) {
            return null;
        }

        p1 = pHead;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        O23_EntryNodeOfLoop test = new O23_EntryNodeOfLoop();
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(6);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a3;

        System.out.print(test.EntryNodeOfLoop_2(a1).val);
    }
}
