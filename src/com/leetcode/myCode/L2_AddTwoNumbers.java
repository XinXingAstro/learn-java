package com.leetcode.myCode;

//57ms
public class L2_AddTwoNumbers {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
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

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNode head = new ListNode(0);
        ListNode pNode = head;
        int carry = 0, sum = 0, x = 0, y = 0;
        while (l1 != null || l2 != null || carry != 0) {
            pNode.next = new ListNode(0);
            x = l1 == null ? 0 : l1.val;
            y = l2 == null ? 0 : l2.val;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            // sum = (x + y + carry) % 10;
            sum = x + y + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? (sum - 10) : sum;
            // carry = (x + y + carry) / 10;
            pNode = pNode.next;
            pNode.val = sum;

        }
        if (head.next == null) return head;
        return head.next;

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

        L2_AddTwoNumbers inst = new L2_AddTwoNumbers();
        inst.addTwoNumbers1(A, D);
    }
}
