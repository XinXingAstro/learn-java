package com.offer.dynamic_programming;

/**
 * 从一个字符串中找出最长不包含重复字符的只字符串，返回该最长子字符串的长度
 *
 * 算法：动态规划
 * 设f(i)表示以第i个字符结尾的不包含重复字符的子字符串的最长长度
 * 则f(i-1)表示第i-1个字符结尾的不包含重复字符的子字符串的最长长度
 * d表示第i个字符现在的位置和上次出现的位置的距离
 * (1)若第i个字符之前没有出现过，或d大于f(i-1) 则 f(i) = f(i-1) + 1;
 * (2)若d小于等于f(i-1) 则f(i) = d;
 */
public class O48_LongestSubstringWithoutDuplication {
    public int getLongestSubstring(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int curLength = 0;
        int maxLength = 0;
        int d = 0;
        int[] position = new int[26];
        for (int i = 0; i < 26; i++) {
            position[i] = -1;
        }
        for (int i = 0; i < str.length(); i++) {
            int p = str.charAt(i) - 'a';
            if (position[p] < 0 || i - position[p] > curLength) {
                curLength++;
            } else {
                if (maxLength < curLength) {
                    maxLength = curLength;
                }
                curLength = i - position[p];
            }
            position[p] = i;
        }
        if (curLength > maxLength) {
            maxLength = curLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        O48_LongestSubstringWithoutDuplication test = new O48_LongestSubstringWithoutDuplication();
        String str = "acfrbarabc";
        System.out.print(test.getLongestSubstring(str));
    }
}
