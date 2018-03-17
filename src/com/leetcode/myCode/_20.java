package com.leetcode.myCode;

import java.util.Stack;


public class _20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            switch (chars[i]) {
                case ')':
                    if (!stack.empty() && stack.peek() == '(') {
                        stack.pop();
                        break;
                    } else return false;
                case '}':
                    if (!stack.empty() && stack.peek() == '{') {
                        stack.pop();
                        break;
                    } else return false;
                case ']':
                    if (!stack.empty() && stack.peek() == '[') {
                        stack.pop();
                        break;
                    } else return false;
                case '(':
                case '{':
                case '[':
                    stack.push(chars[i]);
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        _20 test = new _20();
        System.out.println(test.isValid("([]])"));
    }
}
