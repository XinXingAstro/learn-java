package com.leetcode.myCode;

public class L234_PalindromeLinkedList {
    /**
     * 判断一个单链表是不是回文的
     * 算法：将后一半链表反转，然后判断这两段链表是否相同
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        pre = null;
        fast = slow.next;
        while (fast != null) {
            slow.next = pre;
            pre = slow;
            slow = fast;
            fast = fast.next;
        }
        slow.next = pre;
        pre = head;
        while (pre != null && slow != null) {
            if (pre.val != slow.val) return false;
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}
