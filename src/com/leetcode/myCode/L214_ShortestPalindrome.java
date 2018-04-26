package com.leetcode.myCode;

import java.util.ArrayList;

public class L214_ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s == null) return "";
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        StringBuilder rev = sb.reverse();
        for (int i = 0; i < len; i++) {
            if (s.substring(0, len - i).equals(rev.substring(i))) {
                return rev.substring(0, i) + s;
            }
        }
        return "";
    }
    public String shortestPalindrome2(String s) {
        if (s == null) return "";
        int len = s.length();
        int i = 0;
        for (int j = (len-1); j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) i++;
        }
        if (i == len) return s;
        StringBuilder sb = new StringBuilder(s.substring(i, len));
        return sb.reverse() + shortestPalindrome(s.substring(0, i)) + s.substring(i);
    }
    public String shortestPalindrome_KMP(String s) {
        if (s == null) return "";
        int len = s.length();
        StringBuilder rev = new StringBuilder(s);
        rev = rev.reverse();
        String new_s = s + "#" + rev.toString();
        int newLen = new_s.length();
        int[] f = new int[newLen];
        for (int i = 1; i < newLen; i++) {
            int t = f[i - 1];
            while (t > 0 && new_s.charAt(i) != new_s.charAt(t))
                t = f[t - 1];
            if (new_s.charAt(i) == new_s.charAt(t))
                t++;
            f[i] = t;
        }
        return rev.substring(0, len - f[newLen-1]) + s;
    }
}