package com.leetcode.myCode;

public class L76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] map = new int[256];
        String res = "";
        if (s == null || t.length() > s.length())
            return res;
        char[] sChar = s.toCharArray();
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int min = sChar.length;
        int count = t.length();
        int start = 0;
        for (int end = 0; end < sChar.length; end++) {
            if (map[sChar[end]]-- > 0)
                count--;
            while (count == 0) {
                if (end - start < min) {
                    min = end - start;
                    res = s.substring(start, end + 1);
                }
                if (++map[sChar[start++]] > 0)
                    count++;
            }
        }
        return res;
    }
}
