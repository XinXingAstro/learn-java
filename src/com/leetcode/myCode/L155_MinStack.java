package com.leetcode.myCode;

import java.util.LinkedList;
import java.util.ArrayList;
public class L155_MinStack {

    class MinStack {

        private LinkedList<Integer> stack;
        private LinkedList<Integer> mstack;
        private Integer min = Integer.MAX_VALUE;

        /** initialize your data structure here. */
        public MinStack() {
            this.stack = new LinkedList<>();
            this.mstack = new LinkedList<>();
        }

        public void push(int x) {
            if (x < min) min = x;
            mstack.push(min);
            stack.push(x);
        }

        public void pop() {
            stack.pop();
            mstack.pop();
            if (mstack.isEmpty()) {
                min = Integer.MAX_VALUE;
            } else {
                min = mstack.peek();
            }

        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return mstack.peek();
        }
    }

}
