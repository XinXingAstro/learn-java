package com.leetcode.myCode;

public class L160_IntersectionofTwoLinkedLists {
    /**
     * 找到两个链表的第一个公共节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode l1 = headA;
        ListNode l2 = headB;
        int dif1 = 0;
        int dif2 = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) l1 = l1.next;
            else dif1++;
            if (l2 != null) l2 = l2.next;
            else dif2++;
        }
        l1 = headA;
        l2 = headB;
        if (dif1 != 0){
            for (int i = 0; i < dif1; i++) l2 = l2.next;
        }
        if (dif2 != 0) {
            for (int i = 0; i < dif2; i++) l1 = l1.next;
        }
        while (l1 != null && l2 != null) {
            if (l1 == l2) return l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }
}
