package com.leetcode.myCode;

import java.util.Stack;

public class L856_ScoreofParentheses {
    public int scoreOfParentheses(String S) {
        return helper(S, 0, S.length() - 1);
    }
    public int helper(String S, int start, int end) {
        int count = 0, res = 0;
        for (int i = start; i <= end; i++) {
            count += S.charAt(i) == '(' ? 1 : -1;
            if (count == 0) {
                if (i - start == 1)
                    res++;
                else
                    res += 2 * helper(S, start + 1, i - 1);
                start = i + 1;
            }
        }
        return res;
    }

    public int scoreOfParentheses1(String S) {
        Stack<Integer> stack = new Stack();
        stack.push(0); // The score of the current frame

        for (char c: S.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }

        return stack.pop();
    }

    public int scoreOfParentheses2(String S) {
        int count = 0, res = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                count++;
            } else {
                count--;
                if (S.charAt(i - 1) == '(')
                    res += 1 << count;
            }
        }
        return res;
    }
}
