package com.offer.stack_queue;

import java.util.Stack;

/**
 * 输入一个栈的压入序列，判断后面的序列是不是对应的弹出序列
 * 算法：创建辅助栈，按照压入序列压入，按照弹出序列弹出，看能否执行完
 */
public class O31_StackPushPopOrder {
    public boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null) {
            return false;
        }
        if (pushA.length == 0 && popA.length == 0) {
            return true;
        }
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int pushI = 0;
        int popI = 0;
        while (popI < popA.length) {
            while(stack.empty() || stack.peek() != popA[popI]) { //stack.empty()一定要放到前面，不然会报错
                if (pushI == pushA.length) {
                    return false;
                }
                stack.push(pushA[pushI]);
                pushI++;
            }
            stack.pop();
            popI++;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        O31_StackPushPopOrder test = new O31_StackPushPopOrder();
        System.out.print(test.isPopOrder(pushA, popA));
    }
}
