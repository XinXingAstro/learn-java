package com.leetcode.myCode;

import java.util.ArrayList;
import java.util.List;

public class L438_FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[256];
        for (char c : p.toCharArray())
            map[c]++;

        int count = p.length();
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            if (map[s.charAt(end)]-- > 0){
                count--;
            }

            while (count == 0) {
                if (end - start + 1 == p.length())
                    res.add(start);
                if (++map[s.charAt(start)] > 0)
                    count++;
                start++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        L438_FindAllAnagrams test = new L438_FindAllAnagrams();
        String s = "cbbaebabbacd";
        String p = "abbc";
        System.out.println(test.findAnagrams(s, p));
    }
}
