package com.leetcode.myCode;

public class _21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l2;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    public static void main(String[] args) {
        _21 test = new _21();

//        ListNode A = new ListNode(-9);
//        ListNode B = new ListNode(3);
//        ListNode C = new ListNode(7);
//        ListNode D = new ListNode(5);
//        ListNode E = new ListNode(7);
//        ListNode F = new ListNode(6);
//        A.next = B;
//        B.next = C;
//        D.next = E;
//        E.next = F;

//        ListNode newList = test.mergeTwoLists(A, D);
//        while (newList != null) {
//            System.out.println(newList.val);
//            newList = newList.next;
//        }
    }
}
