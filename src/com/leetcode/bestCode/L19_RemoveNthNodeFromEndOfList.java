package com.leetcode.bestCode;

public class L19_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode one=head;
        ListNode two=head;
        for(int i=0;i<n;i++){
            if(one.next==null)
                return head.next;
            one=one.next;
        }
        while(one.next!=null){
            one=one.next;
            two=two.next;
        }
        ListNode three=two.next.next;
        two.next=three;
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        ListNode runner = dummy;

        while(n>0){
            runner = runner.next;
            n--;
        }
        while(runner.next!=null){
            runner = runner.next;
            node=node.next;
        }

        node.next = node.next.next;
        return dummy.next;
    }
}
