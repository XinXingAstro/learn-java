package com.leetcode.myCode;

import java.util.ArrayList;
import java.util.List;

public class L830_PositionsofLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        if (S == null || S.length() < 3) return new ArrayList();
        int i = 0, j = 1;
        char[] s = S.toCharArray();
        List<List<Integer>> res = new ArrayList();
        while (j < s.length) {
            if (s[i] == s[j]) {
                j++;
            } else {
                if (j - i >= 3) {
                    ArrayList<Integer> tmp = new ArrayList();
                    tmp.add(i);
                    tmp.add(j - 1);
                    res.add(tmp);
                }
                i = j++;
            }
        }
        if (j - i >= 3) {
            ArrayList<Integer> tmp = new ArrayList();
            tmp.add(i);
            tmp.add(j - 1);
            res.add(tmp);
        }
        return res;
    }
}
