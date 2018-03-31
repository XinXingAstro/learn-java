package com.leetcode.myCode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 *   Given linked list: 1->2->3->4->5, and n = 2.
 *   After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * 看似简单实际上需要做很多异常处理
 * 删除头节点
 * 删除尾节点
 * 链表只有一个节点，删除这一节点
 * n大于链表的节点数
 * 链表头节点尾null
 */
public class L19_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //链表头节点为null和链表只有一个节点
        if (head == null || head.next == null) {
            if (n == 1) {
                return null;
            } else {
                return head;
            }
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 1; i <= n ; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                if (i == n) { //此时删除头节点
                    return slow.next;
                }
                return head; //此时说明n大于链表长度
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (slow.next.next != null) {
            slow.next = slow.next.next; //删除中间节点
        } else {
            slow.next = null; //删除尾节点
        }
        return head;
    }
}
