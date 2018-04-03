package org.problems.recursion;

//https://leetcode.com/problems/n-queens-ii/description/
public class NQueens2 {

    private static boolean isValid(boolean[][] board, int x, int y) {
        for (int i = 0; i < board.length; ++i) {
            if (board[i][y])
                return false;
        }
        int i = x;
        int j = y;
        while (i >= 0 && j >= 0)
            if (board[i--][j--])
                return false;
        i = x;
        j = y;
        while (i < board.length && j >= 0)
            if (board[i++][j--])
                return false;
        i = x;
        j = y;
        while (i >= 0 && j < board.length)
            if (board[i--][j++])
                return false;
        i = x;
        j = y;
        while (i < board.length && j < board.length)
            if (board[i++][j++])
                return false;

        return true;
    }

    private static int solveNQueens(boolean[][] board, int row) {
        int result = 0;
        for (int i = 0; i < board.length; ++i) {
            if (isValid(board, row, i)) {
                board[row][i] = true;
                if (row + 1 == board.length) {
                    ++result;
                } else {
                    result += solveNQueens(board, row + 1);
                }
                board[row][i] = false;
            }
        }
        return result;
    }

    public static int totalNQueens(int n) {
        return solveNQueens(new boolean[n][n], 0);
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
}
