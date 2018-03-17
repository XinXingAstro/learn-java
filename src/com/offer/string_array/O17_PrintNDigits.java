package com.offer.string_array;

/**
 * 打印从1到最大的n位数 大数问题 两种算法
 * 1.用字符数组模拟数字加法 逐个打印
 * 2.用字符数组模拟数字 打印0～9的全排列
 */
public class O17_PrintNDigits {
    /**
     * 算法1：字符数组模拟数字加法
     * n 表示数字位数
     */
    public void printDigits_1(int n) {
        char[] nums = new char[n];
        for (int i = 0; i < n; i++) {
            nums[i] = '0';
        }
        while (!increment(nums)) {
            printNumber(nums);
        }
    }

    public boolean increment(char[] nums) {
        boolean isOverFlow = false;
        int takeOver = 0;
        int length = nums.length;

        for (int i = length - 1; i >= 0; i--) {
            int sum = (int)(nums[i] - '0') + takeOver;
            if (i == (length - 1)) {
                sum++;
            }
            if (sum < 10) {
                nums[i] = (char) ('0' + sum);
                break;
            } else {
                if (i == 0) {
                    isOverFlow = true;
                } else {
                    sum -= 10;
                    takeOver = 1;
                    nums[i] = (char)('0' + sum);
                }
            }
        }

        return isOverFlow;
    }

    public void printNumber(char[] nums) {
        boolean isBegin0 = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != '0' && isBegin0 == true) {
                isBegin0 = false;
            }
            if (isBegin0 == false) {
                System.out.print(nums[i]);
            }
        }
        System.out.print(' ');
    }

    /**
     * 算法2：全排列
     *
     */
    public void printDigits_2(int n) {
        if (n <= 0){
            return;
        }

        char[] nums = new char[n];

        for (int i = 0; i < 10; i++) {
            nums[0] = (char)(i + '0');
            printDigitsPermutation(nums, n, 0);
        }
    }
    public void printDigitsPermutation(char[] nums, int length, int index) {
        if (index == (length - 1)) {
            printNumber(nums);
            return;
        }
        for (int i = 0; i < 10; i++) {
            nums[index + 1] = (char)(i + '0');
            printDigitsPermutation(nums, length, index + 1);
        }
    }

    public static void main(String[] args) {
        O17_PrintNDigits test = new O17_PrintNDigits();
        int n = 2;
//        System.out.println();
        test.printDigits_2(2);
/*        System.out.println();
        test.printDigits_1(2);*/

    }

}
