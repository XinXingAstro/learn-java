package com.leetcode.myCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        List<Character> subStr = new ArrayList<>();
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

    public int lengthOfLongestSubstring(String s) {
        int strLength = s.length();
        int ans = 0;
        Map<Character, Integer> strMap = new HashMap<Character, Integer>();
        for (int i = 0, j = 0; j < strLength; j++) {
            char c = s.charAt(j);
            if (strMap.containsKey(c)) {
                i = Math.max(i, strMap.get(c));
            }
            strMap.put(c, j + 1);
            ans = Math.max(ans, j + 1 - i);
        }

        return ans;
    }

    /**
     * 算法3：滑动窗口法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int[] map = new int[256];
        char[] sChar = s.toCharArray();
        int len = 0;
        int count = 0;
        int start = 0;
        for (int end = 0; end < sChar.length; end++) {
            if (++map[sChar[end]] > 1)
                count++;
            while (count > 0) {
                if (map[sChar[start++]]-- > 1)
                    count--;
            }
            len = Math.max(len, end - start + 1);
        }
        return len;
    }
}
