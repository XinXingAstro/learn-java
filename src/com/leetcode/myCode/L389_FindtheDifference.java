package com.leetcode.myCode;

public class L389_FindtheDifference {
    public char findTheDifference(String s, String t) {
        char[] schr = s.toCharArray();
        char[] tchr = t.toCharArray();
        int c = 0;
        for (int i = 0; i < schr.length; i++) {
            c += (tchr[i] - schr[i]);
        }
        return (char)(c + tchr[tchr.length - 1]);
    }
}
