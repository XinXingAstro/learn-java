package com.leetcode.myCode;

public class L537_ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        int[] aNum = getNum(a);
        int[] bNum = getNum(b);
        return String.valueOf(aNum[0]*bNum[0] - aNum[1]*bNum[1]) + "+" + String.valueOf(aNum[0]*bNum[1] + bNum[0]*aNum[1]) + "i";

    }
    public int[] getNum(String str) {
        String[] a = str.split("\\+");
        int[] nums = new int[2];
        for (int i = 0; i < 2; i++) {
            char[] chr = a[i].toCharArray();
            boolean miue = false;
            for (char c : chr) {
                if (c == 'i') break;
                else if (c == '-') miue = true;
                else {
                    nums[i] = nums[i] * 10 + (c - '0');
                }
            }
            nums[i] = miue == true ? -nums[i] : nums[i];
        }
        return nums;
    }

    public String complexNumberMultiply1(String a, String b) {
        int plusA = a.indexOf("+");
        int plusB = b.indexOf("+");
        int nA = a.length();
        int nB = b.length();

        int aReal = Integer.valueOf(a.substring(0, plusA));
        int bReal = Integer.valueOf(b.substring(0, plusB));

        int aImg = Integer.valueOf(a.substring(plusA + 1, nA - 1));
        int bImg = Integer.valueOf(b.substring(plusB + 1, nB - 1));

        int real = aReal * bReal + -1 * aImg * bImg;
        int img = aReal * bImg + bReal * aImg;

        return real + "+" + img + "i";

    }

    public static void main(String[] args) {
        String a = "78+-76i";
        String b = "-86+72i";
        System.out.println(new L537_ComplexNumberMultiplication().complexNumberMultiply(a, b));
    }
}
