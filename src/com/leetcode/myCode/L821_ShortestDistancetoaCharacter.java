package com.leetcode.myCode;

public class L821_ShortestDistancetoaCharacter {
    public int[] shortestToChar(String S, char C) {
        char[] chars = S.toCharArray();
        int[] ans = new int[chars.length];
//        int pre = Integer.MIN_VALUE;
        int pre = -10000;
        for (int i = 0; i < ans.length; i++) {
            if (chars[i] == C)
                pre = i;
            ans[i] = i - pre;
        }
//        pre = Integer.MAX_VALUE;
        pre = 10000;
        for (int i = ans.length - 1; i >= 0; i--) {
            if (chars[i] == C)
                pre = i;
            ans[i] = Math.min(ans[i], pre - i);
        }
        return ans;
    }

    public static void main(String[] args) {
        String S = "loveleetcode";
        char C = 'e';
        L821_ShortestDistancetoaCharacter test = new L821_ShortestDistancetoaCharacter();
        System.out.println(test.shortestToChar(S, C));
    }
}
