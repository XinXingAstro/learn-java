package com.leetcode.myCode;

import java.util.HashMap;

public class L138_CopyListwithRandomPointer {
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    /**
     * 算法1：使用HashMap记录原节点和复制节点
     * @param head
     * @return
     */
    public RandomListNode copyRandomList1(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode l2 = dummy;
        RandomListNode l1 = head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (l1 != null) {
            l2.next = new RandomListNode(l1.label);
            l2 = l2.next;
            map.put(l1, l2);
            l1 = l1.next;
        }
        l2 = dummy.next;
        l1 = head;
        while (l1 != null) {
            l2.random = map.get(l1.random);
            l1 = l1.next;
            l2 = l2.next;
        }
        return dummy.next;
    }

    /**
     * 算法2：将复制节点连接在原节点后面
     * @param head
     * @return
     */
    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) return null;
        RandomListNode l1 = head;
        RandomListNode l2;
        while (l1 != null) {
            l2 = new RandomListNode(l1.label);
            l2.next = l1.next;
            l1.next = l2;
            l1 = l2.next;
        }
        l1 = head;
        while (l1 != null) {
            l2 = l1.next;
            if (l1.random != null) {
                l2.random = l1.random.next;
            }
            l1 = l2.next;
        }
        l1 = head;
        l2 = l1.next;
        RandomListNode head2 = l2;
        while (l1.next != null) {
            l1.next = l2.next;
            if (l1.next == null) break;
            l1 = l1.next;
            l2.next = l1.next;
            l2 = l2.next;
        }
        return head2;
    }
}
