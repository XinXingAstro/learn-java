package com.leetcode.myCode;

public class _7 {
    public static int reverse(int x) {
        int negative = 0;
        if (x < 0) {
            x = -x;
            negative = 1;
        } else if (x == 0) return 0;

        StringBuilder str = new StringBuilder();
        int first = 0;
        while (x > 0) {
            if (x % 10 != 0 || first == 1){
                str.append(x % 10);
                first = 1;
            }
            x /= 10;
        }

        String a = str.toString();
        int y;
        try {
            Integer.parseInt(a);
        } catch(Exception e) {
            return 0;
        }
        if (negative == 0){
            y = Integer.parseInt(a);
        } else {
            y = -Integer.parseInt(a);
        }

        return y;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-10203000));
    }
}
