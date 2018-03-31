package com.leetcode.myCode;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * [
 *   ["ate", "eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 算法：将每个单词拆分，排序，维护一个map
 */
//public class L49_GroupAnagrams {
//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List> ans = new HashMap<>();
//        for (String s : strs) {
//            char[] chr = s.toCharArray();
//            Arrays.sort(chr);
//            String key = String.valueOf(chr);
//            if (!ans.containsKey(key)) {
//                ans.put(key, new ArrayList());
//            }
//            ans.get(key).add(s);
//        }
////        return new ArrayList<ArrayList<String>>(ans.values());
//    }
//}
