package com.offer.string_array;

/**
 * 输入一个字符串，找到第一个只出现一次的字符的位置
 * 算法：
 * 用hashtable统计字符串中每个字符出现的次数，然后遍历hashtable找到第一个值为1的字符
 * 定义一个简化的hashtable，由于char类型数最多有256种可能的值，所以我们定义一个长度为256
 * 的数组，每个字符按其ASCII码为数组中的下标，数组中的数值，为该字符出现的次数
 */
public class O50_1_FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int[] hash = new int[256];
        for (int i = 0; i < str.length(); i++) {
            hash[(int)str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (hash[(int)str.charAt(i)] == 1) {
                return i;
            }
        }
        return 0;
    }
}
