package com.leetcode.myCode;

public class L419_BattleshipsinaBoard {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                else if (i > 0 && board[i - 1][j] == 'X') continue; // 如果它上面的元素就是‘X'则不计算继续循环
                else if (j > 0 && board[i][j - 1] == 'X') continue; // 如果它左边的元素就是‘X’则不计算继续循环
                else count++;
            }
        }
        return count;
    }
}
