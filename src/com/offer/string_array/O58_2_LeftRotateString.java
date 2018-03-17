package com.offer.string_array;

/**
 * 左旋字符串，输入一个字符串，输入一个整数n，将字符串左旋n位
 * 如输入"abcXYZdef"，3，左旋后的结果为："XYZdefabc"
 * 算法：两次翻转
 * 将字符串分为两组，翻转每个组的字符串，然后翻转全部字符串
 * 得到的结构就是左旋n位的结果
 */
public class O58_2_LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] chr = str.toCharArray();
        reverse(chr, 0, n - 1);
        reverse(chr, n, chr.length - 1);
        reverse(chr, 0, chr.length - 1);
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
}
