package com.offer.linkedList;

/**
 * 复制复杂链表，复杂链表中的节点除了有指向下一节点的指针，还有一个指向任意节点的指针
 *
 * 算法1：
 * I.复制链表节点，用next指针连接
 * II.遍历原链表，复制slibing指针
 * 时:O(n^2) 空:O(1)
 *
 * 算法2：空间换时间算法
 * I.复制链表节点，用next指针连接，用一个hash表将原节点和复制节点对存起来
 * II.复制原节点的slibing指针，由于有hash表，查找任一节点都可在O(1)时间内找到
 * 时:O(n) 空:O(n)
 *
 * 算法3：
 * I.将复制出来的链表节点直接连接到原节点后面
 * II.复制原节点的slibing指针时，就可以直接在原节点slibing指向节点的后面一个节点得到复制节点的slibing
 * III.拆分链表，奇数位的是原节点，偶数位的为复制出来的节点
 */
public class O35_CloneComplexList {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        if (pHead.next == null && pHead.random == null) {
            return new RandomListNode(pHead.label);
        }
        cloneNode(pHead);
        cloneRandom(pHead);
        return splitList(pHead);
    }

    public void cloneNode(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode newNode = new RandomListNode(pNode.label);
            newNode.next = pNode.next;
            pNode.next = newNode;
            pNode = newNode.next;
        }
    }

    public void cloneRandom(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            if (pNode.random != null) {
                pNode.next.random = pNode.random.next;
            }
            pNode = pNode.next.next;
        }
    }

    public RandomListNode splitList(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        RandomListNode pClone = pHead.next;
        RandomListNode pCloneHead = pClone;
        while (pNode != null) {
            pNode.next = pNode.next.next;
            pNode = pNode.next;
            if (pNode != null) {
                pClone.next = pClone.next.next;
            }
            pClone = pClone.next;
        }
        return pCloneHead;
    }

    public static void main(String[] args) {
        RandomListNode a1 = new RandomListNode(1);
        RandomListNode a2 = new RandomListNode(2);
        RandomListNode a3 = new RandomListNode(3);
        RandomListNode a4 = new RandomListNode(4);
        RandomListNode a5 = new RandomListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a1.random = a3;
        a2.random = a5;
        a4.random = a2;
        O35_CloneComplexList test = new O35_CloneComplexList();
        RandomListNode temp = test.Clone(a1);
        while (temp != null) {
            System.out.print(temp.label);
            temp = temp.next;
        }
    }
}
