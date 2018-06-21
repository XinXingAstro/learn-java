package com.leetcode.myCode;

public class L476_NumberComplement {
    public int findComplement(int num) {
        int tmp = num, gate = 1, ans = 0;
        while (tmp != 0) {
            tmp >>= 1;
            if (tmp == 0) break;
            gate <<= 1;
            gate |= 1;
        }
        ans = ~num;
        return ans &= gate;
    }

    public static void main(String[] args) {
        System.out.println(new L476_NumberComplement().findComplement(5));
    }
}
