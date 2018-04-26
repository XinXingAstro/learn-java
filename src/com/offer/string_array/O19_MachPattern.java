package com.offer.string_array;

/**
 * 模式匹配
 * 模式中'*'代表前面字符可以出现任意多次
 * '.'代表可以是任意字符
 * 算法：分两种情况讨论
 * 1）后一个字符不是'*'
 * 2）后一个字符是'*'，这里面又有3种情况 *=0 *=1 *=n
 *
 */
public class O19_MachPattern {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }

        return matchCore(str, 0, pattern, 0);
    }

    public boolean matchCore(char[] str, int sIndex, char[] pattern, int pIndex) {
        if (sIndex == str.length && pIndex == pattern.length) {
            return true;
        }
        if (sIndex != str.length && pIndex == pattern.length) {
            return false;
        }
        if (sIndex == str.length && pIndex != pattern.length) {
            if (pattern[pIndex] == '*') {
                return true;
            }
            if ((pIndex + 1) == (pattern.length - 1) && pattern[pIndex + 1] == '*') {
                return true;
            }
            return false;
        }

        //如果下一个字符是'*'
        if ((pIndex + 1) < pattern.length && pattern[pIndex + 1] == '*') {
            //如果'*'前面的字符可以匹配
            if (pattern[pIndex] == str[sIndex] || (pattern[pIndex] == '.' && sIndex != str.length)) {
                return matchCore(str, sIndex, pattern, pIndex + 2)
                        || matchCore(str, sIndex + 1, pattern, pIndex + 2)
                        || matchCore(str, sIndex + 1, pattern, pIndex);
            } else { //如果'*'前面的字符不能匹配
                return matchCore(str, sIndex, pattern, pIndex + 2);
            }
        }

        //如果下一个字符不是'*' 但是当前字符可以匹配
        if (pattern[pIndex] == str[sIndex] || (pattern[pIndex] == '.' && sIndex != str.length)) {
            return matchCore(str, sIndex + 1, pattern, pIndex + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        String str = "";
        String pattern = "c*c*";
        O19_MachPattern test = new O19_MachPattern();
        System.out.print(test.match(str.toCharArray(), pattern.toCharArray()));
    }
}
