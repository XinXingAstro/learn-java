package com.leetcode.myCode;

public class L791_CustomSortString {
    public String customSortString(String S, String T) {
        // 用map统计S中各字符的优先级，字符越考后优先级越高
        // 优先级从1开始，不在S中的字符优先级为0
        int[] map = new int[26];
        char[] s = S.toCharArray();
        for (int i = 0; i < s.length; i++) {
            map[s[i] - 'a'] = i + 1;
        }
        // 我们将T中的每个字符映射为优先级，那么我们就相当于对这几个优先级数字进行排序
        // 我们使用计数排序算法可以达到O(n)时间复杂度
        // count数组中记录各个优先级出现频次
        int[] count = new int[s.length + 1];
        char[] t = T.toCharArray();
        for (int i = 0; i < t.length; i++) {
            count[map[t[i] - 'a']]++;
        }
        // 累加优先级出现的频次，对应各个优先级在结果数组中出现的起始位置
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        // 通过t中每个字符找到对应的优先级，然后在count数组中找到对应位置
        char[] res = new char[t.length];
        for (int i = 0; i < t.length; i++) {
            res[count[map[t[i] - 'a']] - 1] = t[i]; // 由于频次最低为1，所以在映射时要注意索引-1
            count[map[t[i] - 'a']]--;
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String S = "cba";
        String T = "abcd";
        System.out.println(new L791_CustomSortString().customSortString(S, T));
    }
}
