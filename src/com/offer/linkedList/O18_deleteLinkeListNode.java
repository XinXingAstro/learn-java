package com.offer.linkedList;


/**
 * 删除链表节点
 * 注意事项：
 * 1）删除链表尾节点需要遍历链表
 * 2）链表只有一个节点
 * 3）如果要删除的节点不在链表中，这种情况需要让函数调用者处理
 */
public class O18_deleteLinkeListNode {
    public void deleteNode(ListNode head, ListNode node) {
        if (head == null || node == null) {
            return;
        }
        if (node.next == null) {
            if (head == node) {
                head.val = 0;    //要提前问面试官 如果只有一个节点 怎样删除节点
            }
            ListNode tail = head;
            while (tail.next != node) {
                tail = tail.next;
            }
            tail.next = null;
        } else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
