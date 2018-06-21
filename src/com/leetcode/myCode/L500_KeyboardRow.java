package com.leetcode.myCode;

import java.util.ArrayList;
import java.util.List;

public class L500_KeyboardRow {
    public String[] findWords(String[] words) {
        if (words == null || words.length == 0)
            return new String[0];
        List<String> res = new ArrayList<>();
        List<String> map = new ArrayList<>();
        map.add("QqWwEeRrTtYyUuIiOoPp");
        map.add("AaSsDdFfGgHhJjKkLl");
        map.add("ZzXxCcVvBbNnMm");
        for (String word : words) {
            char[] chr = word.toCharArray();
            for (int j = 0; j < 3; j++) {
                if (map.get(j).indexOf(chr[0]) != -1) {
                    String line = map.get(j);
                    int i;
                    for (i = 0; i < chr.length; i++) {
                        if (line.indexOf(chr[i]) == -1)
                            break;
                    }
                    if (i == chr.length) {
                        res.add(word);
                        break;
                    }
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
