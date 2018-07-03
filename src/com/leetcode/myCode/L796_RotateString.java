package com.leetcode.myCode;

public class L796_RotateString {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length())
            return false;
        return (A + A).contains(B);
    }

    public static void main(String[] args) {
        String a = "bqqutquvbtgouklsayfvzewpnrbwfcdmwctusunasdbpbmhnvy";
        String b = "wpnrbwfcdmwctusunasdbpbmhnvybqqutquvbtgouklsayfvze";
        System.out.println(new L796_RotateString().rotateString(a, b));
    }
}
