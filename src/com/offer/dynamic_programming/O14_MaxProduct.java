package com.offer.dynamic_programming;

/**
 * 定理：任意分割一个整数n，使各部分乘机最大：尽量多的分出3，如果n%3 = 1，则3少分割一次（即最后的4不分割）
 */
public class O14_MaxProduct {
    /**
     * 动态规划发解最大乘积
     */
    public int maxProduct_Dynamic(int length) {
        //这里默认至少分割一次，所以才会有这几个if
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        int[] product = new int[length + 1];
        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;

        int max = 0;
        for (int i = 4; i <= length; i++) {
            for (int j = 1; j <= i>>1; j++) {
                int p = product[j] * product[i - j];
                if (max < p) {
                    max = p;
                    product[i] = max;
                }
            }
        }

        return product[length];
    }

    /**
     * 贪心法求最大值，应用最上面定理
     */
    public int maxProduct_Greedy(int length) {
        //这里默认至少分割一次，所以才会有这几个if
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        int timeOf3 = length / 3;
        if (length - (timeOf3 * 3) == 1) {
            timeOf3--;
        }
        int timeOf2 = (length - (timeOf3 * 3)) >> 1;

        return (int)Math.pow(3, timeOf3) * (int)Math.pow(2, timeOf2);
    }

    public static void main(String[] args) {
        O14_MaxProduct test = new O14_MaxProduct();
        int length = 9;
        System.out.println(test.maxProduct_Dynamic(length));
        System.out.println(test.maxProduct_Greedy(length));
    }
}
