package com.offer.string_array;

/**
 * 将数字翻译成字符串
 * 0～25和数字分别对应a～z字母，数字是连续一的一串数字，一位数字可以翻译成字母
 * 小于25的两位数字也可以翻译成一个字母，要求计算出一个数字有多少种不同的翻译方法
 *
 * 算法：
 * f(i) = f(i+1) + g(i,i+1)*f(i+2)
 * f(i)表示从第i位数字开始的不同翻译的数目，当第i位和第i+1位两位数字拼接起来的数字在10～25的范围内时，
 * 函数g(i,i+1)的值为1，否则为0。
 */
public class O46_TranslateNumToString {
    public int getTranslateCount(int number) {
        String str = number + "";
        int length = str.length();
        int[] counts = new int[length];
        int fi = 0;
        for (int i = length - 1; i >= 0; i--) {
            fi = 0;
            if (i < length - 1) {
                fi = counts[i + 1];
            } else {
                fi = 1;
            }

            if (i < length - 1) {
                int d1 = str.charAt(i) - '0';
                int d2 = str.charAt(i + 1) - '0';
                int converted = d1 * 10 + d2;
                if (converted >= 10 && converted <= 25) {
                    if (i < length - 2) {
                        fi += counts[i + 2];
                    } else {
                        fi += 1;
                    }
                }
            }

            counts[i] = fi;
        }

        return counts[0];
    }

    public static void main(String[] args) {
        O46_TranslateNumToString test = new O46_TranslateNumToString();
        int numbers = 12214;
        System.out.print(test.getTranslateCount(numbers));
    }
}
