package com.leetcode.myCode;

import java.util.LinkedList;
import java.util.Stack;

public class L394_DecodeString {
    public String decodeString(String s) {
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<StringBuilder> strStack = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        char[] chrs = s.toCharArray();
        for (int i = 0; i < chrs.length; i++) {
            if (Character.isDigit(chrs[i])) {
                int count = 0;
                while (Character.isDigit(chrs[i])) {
                    count = count * 10 + (chrs[i++]-'0');
                }
                numStack.push(count);
                i--;
            } else if (chrs[i] == '[') {
                strStack.push(res);
                res = new StringBuilder();
            } else if (chrs[i] == ']') {
                StringBuilder tmp = strStack.pop();
                int num = numStack.pop();
                for (int j = 0; j < num; j++) {
                    tmp.append(res);
                }
                res = tmp;
            } else {
                res.append(chrs[i]);
            }
        }
        return res.toString();
    }
}
