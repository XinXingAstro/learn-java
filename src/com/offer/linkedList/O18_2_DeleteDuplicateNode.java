package com.offer.linkedList;


/**
 * 删除链表中重复节点
 */
public class O18_2_DeleteDuplicateNode {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode pNode = pHead;
        ListNode preNode = null;
        boolean duplicate = false;

        while (pNode != null && pNode.next != null) {
            if (pNode.val != pNode.next.val && duplicate == false) {
                if (preNode == null) {
                    pHead = pNode;
                    preNode = pNode;
                } else {
                    preNode.next = pNode;
                    preNode = preNode.next;
                }
                pNode = pNode.next;
            } else if (pNode.val != pNode.next.val && duplicate == true){
                duplicate = false;
                pNode = pNode.next;
            } else if (pNode.val == pNode.next.val) {
                duplicate = true;
                pNode = pNode.next;
            }
        }
        if (duplicate == true) {
            if (preNode == null) {
                return null;
            } else {
                preNode.next = null;
            }
        }
        if(duplicate == false) {
            if (preNode == null) {
                pHead = pNode;
            } else {
                preNode.next = pNode;
            }
        }

        return pHead;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(3);
        ListNode a5 = new ListNode(4);
        ListNode a6 = new ListNode(4);
        ListNode a7 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;

        O18_2_DeleteDuplicateNode test = new O18_2_DeleteDuplicateNode();
        ListNode pHead = test.deleteDuplication(a1);;
        while (pHead != null) {
            System.out.print(pHead.val);
            pHead = pHead.next;
        }

    }
}
