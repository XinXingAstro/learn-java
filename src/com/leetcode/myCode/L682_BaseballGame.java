package com.leetcode.myCode;

import java.util.LinkedList;

public class L682_BaseballGame {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0)
            return 0;
        LinkedList<Integer> stack = new LinkedList<>();
        int sum = 0;
        for (String s : ops) {
            if (Character.isDigit(s.charAt(0)) || s.charAt(0) == '-') {
                int num = Integer.parseInt(s);
                sum += num;
                stack.push(num);
            } else if (s.equals("+")) {
                int tmp1 = stack.pop();
                int tmp2 = stack.pop();
                int num = tmp1 + tmp2;
                sum += num;
                stack.push(tmp2);
                stack.push(tmp1);
                stack.push(num);
            } else if (s.equals("D")) {
                int num = stack.peek() * 2;
                sum += num;
                stack.push(num);
            } else if (s.equals("C")) {
                sum -= stack.pop();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] ops = {"5","2","C","D","+"};
        System.out.println(new L682_BaseballGame().calPoints(ops));
    }
}
