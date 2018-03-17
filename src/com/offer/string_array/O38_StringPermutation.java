package com.offer.string_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 * 字符串的全排列（背）
 * 算法：输出全排列算法
 * 将字符数组看成两部分，第一个字符和后面的字符，依次将第一个字符和后面各字符交换位置，
 * 然后递归的将后面字符数组的第一个字符依次跟后面字符交换
 */
public class O38_StringPermutation {
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<String>();
        }
        ArrayList<String> output = new ArrayList<String>();
        TreeSet<String> temp = new TreeSet<String>();
        permutationCore(str.toCharArray(), 0, temp);
        output.addAll(temp);
        //Collections.sort(output);
        return output;
    }

    public void permutationCore(char[] chr, int start, TreeSet<String> output) {
        if (start == chr.length - 1) {
            output.add(new String(chr));
            return;
        } else {
            for (int i = start; i < chr.length; i++) {
                //if (i == start || chr[i] != chr[start]) {
                //依次将第一个字符和后面的字符交换
                swap(chr, i, start);

                //递归的对后面的字符串做同样操作
                permutationCore(chr, start + 1, output);

                //将第一个字符交换回来，准备和下一个字符交换
                swap(chr, i, start);
               // }
            }
        }
    }

    public void swap(char[] chr, int a, int b) {
        char temp = chr[a];
        chr[a] = chr[b];
        chr[b] = temp;
    }

    public static void main(String[] args) {
        O38_StringPermutation test = new O38_StringPermutation();
        String str = "abba";
        System.out.println(test.Permutation(str));
    }
}
