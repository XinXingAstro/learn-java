package com.offer.linkedList;

import java.util.ArrayList;
import java.util.Stack;



public class O6_PrintListFromTailToHead {
    /**
     * 从后向前打印链表，算法分两步
     * I.遍历链表，将链表节点存放在栈中
     * II.从栈中弹出链表节点
     *
     * 也可以用递归算法实现，但是若链表过长有可能会使递归栈溢出
     */
    public static ArrayList<Integer> printList(ListNode listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

}
