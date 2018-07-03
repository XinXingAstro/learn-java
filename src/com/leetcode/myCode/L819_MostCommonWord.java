package com.leetcode.myCode;

import java.util.ArrayList;
import java.util.HashMap;

public class L819_MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        String[] words = paragraph.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (!Character.isLetter(words[i].charAt(words[i].length() - 1))) {
                words[i] = words[i].substring(0, words[i].length() - 1);
            }
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        ArrayList<String> ban = new ArrayList<>();
        for (int i = 0; i < banned.length; i++) {
            ban.add(banned[i]);
        }
        int max = 0;
        String res = "";
        for (String word : map.keySet()) {
            if (ban.contains(word)) continue;
            if (map.get(word) > max) {
                max = map.get(word);
                res = word;
            }
        }
        return res;
    }
}
