package com.leetcode.myCode;

import java.util.HashSet;

public class L804_UniqueMorseCodeWords {
    private String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> hashSet = new HashSet<>();
        for (String word : words) {
            hashSet.add(transfor(word));
        }
        return hashSet.size();
    }
    
    public String transfor(String word) {
        char[] chr = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chr) {
            sb.append(morse[c - 'a']);
        }
        return sb.toString();
    }
}
