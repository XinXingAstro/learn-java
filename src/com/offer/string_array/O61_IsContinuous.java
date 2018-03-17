package com.offer.string_array;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，大小王可以看做任何数
 * 算法：
 * 将大小王看作0
 * I.将数组排序
 * II.统计0的个数
 * III.统计空缺的个数，如果空缺个数小于0的个数，则可以成为一个顺子
 * 注意：如果数组中出现重复数字这返回false
 */
public class O61_IsContinuous {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 5) {
            return false;
        }
        Arrays.sort(numbers);
        int numOfZero = 0;
        for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
            numOfZero++;
        }
        int numOfGap = 0;
        for (int i = (numOfZero == 0 ? 1 : (numOfZero + 1)); i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1]) {
                return false;
            }
            numOfGap += numbers[i] - numbers[i - 1] - 1;
        }

        return numOfZero >= numOfGap ? true : false;
    }
    public static void main(String[] args) {
        O61_IsContinuous test = new O61_IsContinuous();
        int[] numbers = {0,3,2,6,4};
        System.out.print(test.isContinuous(numbers));
    }
}
