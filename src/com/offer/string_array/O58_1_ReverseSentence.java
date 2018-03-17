package com.offer.string_array;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但是单词内字符的顺序不变，
 * 为简单起见，标点符号和普通字母一样处理
 * 算法：两次翻转
 * 先翻转整个句子，再翻转句子中的每个单词
 */
public class O58_1_ReverseSentence {
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] chr = str.toCharArray();
        reverse(chr, 0, chr.length - 1);
        int start = 0;
        int end = 0;
        while (end <= chr.length) {
            if (end == chr.length || chr[end] == ' ') {
                reverse(chr, start, end - 1);
                end++;
                start = end;
            } else {
                end++;
            }
        }
        return new String(chr);
    }
    public void reverse(char[] chr, int start, int end) {
        if (chr == null || chr.length == 0) {
            return;
        }
        while (start < end) {
            char temp = chr[start];
            chr[start] = chr[end];
            chr[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        O58_1_ReverseSentence test = new O58_1_ReverseSentence();
        String str = "I am a student.";
        System.out.print(test.ReverseSentence(str));
    }
}
