package com.offer.string_array;

/**
 * 凡是会让字符串或数组变长的操作都可以使用以下算法：
 * I.统计操作完成后数组或字符串的总长度；
 * II.从末尾开始合并两字符串或数组，这样可以避免很多重复的移动。
 *
 * 同类题Leetcode 88
 */
public class O5_replaceSpaces {
    public static String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0) {
            return "";
        }


        int spaces = 0;
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (c.equals(' ')) {
                spaces++;
            }
        }

        int i = str.length() - 1;
        str.setLength(i + 1 + (spaces * 2));
        int j = str.length() - 1;
        while (i >= 0) {
            Character c = str.charAt(i);
            if (c.equals(' ')) {
                i--;
                str.setCharAt(j, '0');
                j--;
                str.setCharAt(j, '2');
                j--;
                str.setCharAt(j, '%');
                j--;
            } else {
                i--;
                str.setCharAt(j, c);
                j--;
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("   a");
//        System.out.println(str.length());
//        System.out.println(str.charAt(5));
        System.out.println(replaceSpace(str));

    }
}
