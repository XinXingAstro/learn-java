package com.leetcode.myCode;

public class L712_MinimumASCIIDeleteSumforTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        char[] chr1 = s1.toCharArray();
        char[] chr2 = s2.toCharArray();
        int[][] dp = new int[chr1.length + 1][chr2.length + 1];
        for (int i = chr2.length - 1; i >= 0; i--) {
            dp[chr1.length][i] = dp[chr1.length][i + 1] + chr2[i];
        }
        for (int i = chr1.length - 1; i >= 0; i--) {
            dp[i][chr2.length] = dp[i + 1][chr2.length] + chr1[i];
        }
        for (int i = chr1.length - 1; i >= 0; i--) {
            for (int j = chr2.length - 1; j >= 0; j--) {
                if (chr1[i] == chr2[j])
                    dp[i][j] = dp[i + 1][j + 1];
                else
                    dp[i][j] = Math.min(dp[i + 1][j] + chr1[i], dp[i][j + 1] + chr2[j]);
            }
        }
        return dp[0][0];
    }
    public int minimumDeleteSum1(String s1, String s2) {
        char[] chr1 = s1.toCharArray();
        char[] chr2 = s2.toCharArray();
        int[][] dp = new int[chr1.length + 1][chr2.length + 1];
        for (int i = 1; i <= chr1.length; i++) {
            dp[i][0] = dp[i - 1][0] + chr1[i - 1];
        }
        for (int i = 1; i <= chr2.length; i++) {
            dp[0][i] = dp[0][i - 1] + chr2[i - 1];
        }
        for (int i = 1; i <= chr1.length; i++) {
            for (int j = 1; j <= chr2.length; j++) {
                if (chr1[i - 1] == chr2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j] + chr1[i - 1], dp[i][j - 1] + chr2[j - 1]);
            }
        }
        return dp[chr1.length][chr2.length];
    }
}
