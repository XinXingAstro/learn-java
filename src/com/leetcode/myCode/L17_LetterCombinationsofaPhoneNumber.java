package com.leetcode.myCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class L17_LetterCombinationsofaPhoneNumber {
    private String[] digitLetters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            ans = combine(ans, digitLetters[digits.charAt(i) - '0']);
        }
        return ans;
    }
    public List<String> combine(List<String> ans, String str) {
        List<String> res = new ArrayList<>();
        for (String s : ans) {
            for (int i = 0; i < str.length(); i++) {
                res.add(s + str.charAt(i));
            }
        }
        return res;
    }
}
