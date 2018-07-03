package com.leetcode.myCode;

public class L696_CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int ans = 0, prev = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        return ans + Math.min(prev, cur);
    }

    public static void main(String[] args) {
        String s = "10101";
        System.out.println(new L696_CountBinarySubstrings().countBinarySubstrings(s));
    }
}
