package com.offer.linkedList;

/**
 * 合并两个排序的链表
 * 一种算法，分别用迭代和递归实现
 */
public class O25_MergeList {

    /**
     * 合并两链表的迭代算法
     * @param list1
     * @param list2
     * @return
     */
    public ListNode merge_iterative(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode pHead = list1.val < list2.val ? list1 : list2;
        ListNode pNode = pHead;
        if (pNode == list1) {
            list1 = list1.next;
        } else {
            list2 = list2.next;
        }
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pNode.next = list1;
                list1 = list1.next;
                pNode = pNode.next;
            } else {
                pNode.next = list2;
                list2 = list2.next;
                pNode = pNode.next;
            }
        }
        if (list1 == null && list2 != null) {
            pNode.next = list2;
        }
        if (list1 != null && list2 == null) {
            pNode.next = list1;
        }

        return pHead;
    }


    /**
     * 合并两链表的递归算法
     * @param list1
     * @param list2
     * @return
     */
    public ListNode merge_recursive(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode pHead = null;
        if (list1.val < list2.val) {
            pHead = list1;
            pHead.next = merge_recursive(list1.next, list2);
        } else {
            pHead = list2;
            pHead.next = merge_recursive(list1, list2.next);
        }

        return pHead;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        /*ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(5);
        ListNode a4 = new ListNode(7);
        ListNode a5 = new ListNode(9);*/
        a1.next = null;//a2;
        /*a2.next = a3;
        a3.next = a4;
        a4.next = a5;*/
        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(4);
        ListNode b3 = new ListNode(6);
        ListNode b4 = new ListNode(8);
        ListNode b5 = new ListNode(10);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;

        O25_MergeList test = new O25_MergeList();
        ListNode head = test.merge_iterative(a1, b1);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
