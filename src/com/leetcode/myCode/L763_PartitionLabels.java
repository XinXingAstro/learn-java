package com.leetcode.myCode;

import java.util.ArrayList;
import java.util.List;

public class L763_PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0)
            return res;
        int[] end = new int[26];
        char[] chr = S.toCharArray();
        for (int i = 0; i < chr.length; i++) {
            end[chr[i] - 'a'] = i;
        }
        int start = 0;
        while (start < chr.length) {
            int endPosition = end[chr[start] - 'a'];
            for (int i = start; i <= endPosition; i++) {
                if (end[chr[i] - 'a'] > endPosition)
                    endPosition = end[chr[i] - 'a'];
            }
            res.add(endPosition - start + 1);
            start = endPosition + 1;
        }
        return res;
    }
}
