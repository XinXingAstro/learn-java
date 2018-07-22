package com.leetcode.myCode;

public class L25_ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy, end = dummy;
        while(true) {
            int i = 0;
            for (;i < k; i++) {
                end = end.next;
                if (end == null) break;
            }
            if(i == k) {
                ListNode pos = cur.next;
                for (int j = 0; j < k-1; j++) {
                    ListNode pNode = cur.next;
                    cur.next = cur.next.next;
                    pNode.next = end.next;
                    end.next = pNode;
                }
                cur = pos;
                end = cur;
            } else
                break;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        L25_ReverseNodesinkGroup test = new L25_ReverseNodesinkGroup();
        test.reverseKGroup(a, 2);
    }
}
