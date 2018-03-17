package com.leetcode.myCode;

import java.util.HashMap;
import java.util.Map;

public class _3_2 {
    public int lengthOfLongestSubstring(String s) {
        int strLength = s.length();
        int ans = 0;
        Map<Character, Integer> strMap = new HashMap<Character, Integer>();
        for (int i = 0, j = 0; j < strLength; j++) {
            char c = s.charAt(j);
            if (strMap.containsKey(c)) {
                i = Math.max(i, strMap.get(c));
            }
            strMap.put(c, j);
            ans = Math.max(ans, j - i);
        }

        return ans;
    }
    public static void main(String[] args) {
        _3_2 test = new _3_2();
        String s = "abcdbsfg";
        System.out.println(test.lengthOfLongestSubstring(s));
    }
}
