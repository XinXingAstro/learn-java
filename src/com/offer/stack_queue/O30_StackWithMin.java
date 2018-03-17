package com.offer.stack_queue;

import java.util.Stack;

/**
 * 包含min函数的栈
 * 注意：min函数可以随时返回当前栈中最好的元素，
 * 而不是初始状态下的一个最小函数。
 *
 * 算法：定义两个栈：数据栈，辅助栈；
 * 数据栈中每压入一个数据，辅助栈中就压入当前数据栈中的最小元素
 * 数据栈中每弹出一个元素，辅助栈中也弹出一个元素，辅助栈中弹出的元素
 * 就是当前数据栈中的最小值。
 *
 * 分析问题时要画表格
 */
public class O30_StackWithMin {

    Stack<Integer> dataStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int node) {
        dataStack.push(node);
        if (minStack.empty() || minStack.peek() > node) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
