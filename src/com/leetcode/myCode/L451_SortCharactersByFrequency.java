package com.leetcode.myCode;

import java.util.Arrays;

public class L451_SortCharactersByFrequency {
    public String frequencySort(String s) {
        int[] freq = new int[256];
        char[] chr = s.toCharArray();
        for (int i = 0; i < chr.length; i++) {
            freq[chr[i]]++;
        }
        int i = 0;
        char[] res = new char[chr.length];
        while (i < chr.length) {
            int max = 0;
            char c = 0;
            for (int j = 0; j < 256; j++) {
                if (max < freq[j]){
                    max = freq[j];
                    c = (char)j;
                }
            }
            freq[c] = 0;
            while (max-- > 0) {
                res[i++] = c;
            }
        }
        return String.valueOf(res);
    }

    //使用技术排序算法对频率进行排序
    public String frequencySort1(String s) {
        char[] chr = s.toCharArray();
        Arrays.sort(chr);
        int[] freq = new int[256];
        for (int i = 0; i < chr.length; i++) {
            freq[chr[i]]++;
        }
        int[] count = new int[chr.length + 1];
        for (int i = 0; i < chr.length; i++) {
            count[freq[chr[i]]]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        char[] res = new char[chr.length];
        for (int i = 0; i < chr.length; i++) {
            res[res.length - count[freq[chr[i]]]] = chr[i];
            count[freq[chr[i]]]--;
        }
        return String.valueOf(res);
    }
}
