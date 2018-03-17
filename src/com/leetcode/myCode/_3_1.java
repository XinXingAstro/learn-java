package com.leetcode.myCode;

import java.util.ArrayList;
import java.util.List;

public class _3_1 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        List<Character> subStr = new ArrayList<Character>();
        int maxSubLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!subStr.contains(c)) {
                subStr.add(c);
                maxSubLength = Math.max(maxSubLength, subStr.size());
            } else {
                i = i - subStr.size() + subStr.indexOf(c);
                subStr.clear();
            }
        }

        return maxSubLength;
    }
    public static void main(String[] args) {
        _3_1 test = new _3_1();
        String s = "dvdf";
        System.out.println(test.lengthOfLongestSubstring(s));
    }
}
