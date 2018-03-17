package com.offer.string_array;

/**
 * 在字符流中找出第一个只出现一次的字符
 * 算法：
 * 用hash表存储字符在字符流中出现的序号，hash表中初始值为-1，如果一个字符出现两次，则把值设置为-2
 *
 * 问题：
 * 如果当前字符流没有只出现一次的字符时返回什么？
 */
public class O50_2_FindNotRepeatChar {
    //定义存储字符序号的hash表
    public int[] indexArray = new int[256];
    int index = 0;
    {
        for (int i = 0; i < 256; i++) {
            indexArray[i] = -1;
        }
    }
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (indexArray[(int)ch] == -1) {
            indexArray[(int)ch] = index;
        } else if (indexArray[(int)ch] >= 0) {
            indexArray[(int)ch] = -2;
        }
        index++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int minIndex = Integer.MAX_VALUE;
        char chr = '#';
        for (int i = 0; i < 256; i++) {
            if (indexArray[i] >= 0 && indexArray[i] < minIndex) {
                minIndex = indexArray[i];
                chr = (char)i;
            }
        }
        return chr;
    }
}
