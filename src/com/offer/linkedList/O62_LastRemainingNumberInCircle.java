package com.offer.linkedList;

/**
 * 约瑟夫(Josephuse)环问题
 * 0～n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
 * 求这个圆圈里剩下的最后一个数字
 * 算法1：用环形链表模仿这个过程
 * 算法2：用递推公式直接计算
 * 设f(n,m)表示每次在n个数字中删除第m个数字左后剩下的数字则有
 * 若n = 1, f(n,m) = 0
 * 若n > 1, f(n,m) = [f(n-1,m) + m] % n
 */
public class O62_LastRemainingNumberInCircle {
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
