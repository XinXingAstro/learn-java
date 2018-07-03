package com.leetcode.myCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class L784_LetterCasePermutation {
    private List<String> res = new ArrayList();
    public List<String> letterCasePermutation(String S) {
        helper(S, 0);
        return res;
    }
    public void helper(String s, int index) {
        if (s == null || index == s.length()) {
            res.add(s);
            return;
        }

        if (Character.isLetter(s.charAt(index))) {
            char[] chr = s.toCharArray();
            chr[index] = Character.toLowerCase(chr[index]);
            helper(String.valueOf(chr), index + 1);
            chr[index] = Character.toUpperCase(chr[index]);
            helper(String.valueOf(chr), index + 1);
        } else {
            helper(s, index + 1);
        }
    }
    public List<String> letterCasePermutation1(String S) {
        List<String> res = new ArrayList();
        if (S == null) return res;
        Queue<String> queue = new ArrayDeque();
        queue.offer(S);
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    char[] chr = queue.poll().toCharArray();

                    chr[i] = Character.toLowerCase(chr[i]);
                    queue.offer(String.valueOf(chr));

                    chr[i] = Character.toUpperCase(chr[i]);
                    queue.offer(String.valueOf(chr));
                }
            }
        }
        return new ArrayList(queue);
    }
}
