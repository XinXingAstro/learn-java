package com.leetcode.myCode;

public class L844_BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder s = new StringBuilder(S);
        StringBuilder t = new StringBuilder(T);
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '#') {
                s.deleteCharAt(i);
                if (i - 1 >= 0) s.deleteCharAt(--i);
            } else
                i++;
        }
        i = 0;
        while (i < t.length()) {
            if (t.charAt(i) == '#') {
                t.deleteCharAt(i);
                if (i - 1 >= 0) t.deleteCharAt(--i);
            } else
                i++;
        }
        return s.toString().equals(t.toString());
    }

    public static void main(String[] args) {
        String a = "a##c";
        String b = "#a#c";
        System.out.println(new L844_BackspaceStringCompare().backspaceCompare(a, b));
    }
}
