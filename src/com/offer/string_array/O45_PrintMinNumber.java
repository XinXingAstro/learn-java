package com.offer.string_array;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 输入一个数组，输出这个数组中所有数所能组成的最小数
 * 算法：
 * 定义一种新的排序规则，对于两个数n和m，
 * 若 nm < mn 则 n < m
 * 若 nm > mn 则 n > m
 * 若 nm = mn 则 n = m
 * 用这种方法对数组进行排序，最后输出结果
 */
public class O45_PrintMinNumber {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }

        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i : numbers) {
            nums.add(i);
        }
        nums.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = "" + o1 + o2;
                String str2 = "" + o2 + o1;
                return str1.compareTo(str2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.size(); i++) {
            sb.append("" + nums.get(i).intValue());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        O45_PrintMinNumber test = new O45_PrintMinNumber();
        int[] numbers = {3,2,1,4,5};
        System.out.print(test.PrintMinNumber(numbers));
    }
}
