package com.offer.math;

/**
 * 1~n整数中1出现的次数
 * 算法：
 * 将数分段递归求出，每次递归数据减少一位最高位
 * I.拆分数字1～n，如将21345拆分为1346～21345，正好两万和数
 * II.计算1出现在首位的次数，如果首位数大于一，如1346～21345，则1出现次数为10000～19999，10000次
 * 如果首位等于1，如347～1346，则首位出现次数为1000～1346，347次
 * III.由于其他为都可以出现0～9的任意数字，所以出现1和组合数为：首位数*C(位数,1)*C(10,1)...(位数-1和)
 * 即：在数字任意一位中选一位作为1，其他位可以在0～9这十个数字中任意选择，这样的组合在首位进位后，就会重新出现一次
 * 所以要乘以首位数倍。
 * IV.对于剩下的数，做递归处理，如1～1345，1～346
 */
public class O43_NumberOf1Between1andN {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) {
            return 0;
        }
        StringBuilder str = new StringBuilder(n + "");
        int length = str.length();
        int first = str.charAt(0) - '0';
        if (length == 1 && first == 0) {
            return 0;
        }
        if (length == 1 && first > 0) {
            return 1;
        }
        // I II
        int nFirst = 0;
        if (first == 1) {
            nFirst = Integer.parseInt(str.substring(1)) + 1;
        } else if (first > 1) {
            nFirst = (int)Math.pow(10.0, length - 1);
        }
        // III
        int nOther = first*(length-1)*(int)Math.pow(10.0,length - 2);
        // IV
        int nRecursive = NumberOf1Between1AndN_Solution(Integer.parseInt(str.substring(1)));

        return nFirst + nOther + nRecursive;
    }
}
