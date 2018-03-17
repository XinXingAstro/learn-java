package com.offer.math;

/**
 * 找到第1500个丑数
 * 丑数：只包含因子2、3和5的数称为丑数，求从小到大的顺序的第1500个丑数
 * 算法1：逐个计算每一个数是不是丑数，直到找到第1500个丑数
 * 算法2：用空间换时间
 * 由丑数的定义可知，一个丑数是由另一个丑数乘以2、3或5得到的，因此，可以创建一个数组保存前面的丑数
 * 然后逐个计算出第1500个丑数
 */
public class O49_UglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] uglyNums = new int[index];
        uglyNums[0] = 1;
        int next = 1;
        int m2 = 0;
        int m3 = 0;
        int m5 = 0;
        while (next < index) {
            int min = min(uglyNums[m2] * 2, uglyNums[m3] * 3, uglyNums[m5] * 5);
            uglyNums[next] = min;

            while (uglyNums[m2] * 2 <= min) {
                m2++;
            }
            while (uglyNums[m3] * 3 <= min) {
                m3++;
            }
            while (uglyNums[m5] * 5 <= min) {
                m5++;
            }
            next++;
        }
        return uglyNums[next - 1];
    }
    public int min(int a, int b, int c) {
        int min = a < b ? a : b;
        return min < c ? min : c;
    }
}
