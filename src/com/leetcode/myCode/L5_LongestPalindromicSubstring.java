package com.leetcode.myCode;

public class L5_LongestPalindromicSubstring {
    private int start;
    private int end;
    private int maxLen;
    public String longestPalindrome(String s) {
        if (s == null) return null;
        for (int i = 0; i < s.length(); i++) {
            getLength(s, i, i);
            getLength(s, i, i+1);
        }
        return s.substring(start, end + 1);
    }
    public void getLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        int len = right - left - 1;
        if (len > maxLen) {
            maxLen = len;
            start = left + 1;
            end = right - 1;
        }
    }
}
