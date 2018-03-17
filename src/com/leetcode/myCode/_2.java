package com.leetcode.myCode;

//57ms
public class _2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode l4 = null;
        ListNode l5 = null;

        l3 = new ListNode(0);
        l4 = l3;
        l5 = l3;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                l3.val += (l1.val + l2.val);
                if (l3.val >= 10 || l1.next != null || l2.next != null) l3.next = new ListNode(0);
                l3 = l3.next;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null && l2 != null) {
                l3.val = l2.val;
                if (l3.val >= 10 || l2.next != null ) l3.next = new ListNode(0);
                l3 = l3.next;
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                l3.val = l1.val;
                if (l3.val >= 10 || l1.next != null) l3.next = new ListNode(0);
                l3 = l3.next;
                l1 = l1.next;
            }
        }
        while (l4 != null) {
            if (l4.val >= 10) {
                if (l4.next == null) {
                    l4.next = new ListNode(0);
                }
                l4.next.val++;
                l4.val -= 10;
            }
            l4 = l4.next;
        }

        return l5;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(2);
        ListNode B = new ListNode(4);
        ListNode C = new ListNode(3);
        A.next = B;
        B.next = C;

        ListNode D = new ListNode(5);
        ListNode E = new ListNode(6);
        ListNode F = new ListNode(4);
        D.next = E;
        E.next = F;

        _2 inst = new _2();
        inst.addTwoNumbers(A, D);
    }
}
