package com.leetcode.myCode;

public class L79_WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] wrd = word.toCharArray();
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (wrd[0] == board[i][j] && search(board, wrd, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, char[] wrd, int i, int j, int index) {
        if (index == wrd.length)
            return true;

        if (i>=board.length || i<0 || j>=board[i].length || j<0 || board[i][j] != wrd[index])
            return false;

        board[i][j] ^= 256;
        boolean exist = search(board, wrd, i+1, j, index+1) ||
                search(board, wrd, i-1, j, index+1) ||
                search(board, wrd, i, j+1, index+1) ||
                search(board, wrd, i, j-1, index+1);
        board[i][j] ^= 256;

        return exist;
    }
}
