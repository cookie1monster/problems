package org.problems.recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/n-queens/description/
public class NQueens {

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

    private static List<String> convert(boolean[][] board) {
        List<String> result = new ArrayList<>(board.length);
        for (int i = 0; i < board.length; ++i) {
            StringBuilder line = new StringBuilder(board.length);
            for (int j = 0; j < board.length; ++j) {
                line = line.append((board[i][j]) ? 'Q' : '.');
            }
            result.add(line.toString());
        }
        return result;
    }

    private static void solveNQueens(boolean[][] board, int row, List<List<String>> result) {
        for (int i = 0; i < board.length; ++i) {
            if (isValid(board, row, i)) {
                board[row][i] = true;
                if (row + 1 == board.length) {
                    result.add(convert(board));
                } else {
                    solveNQueens(board, row + 1, result);
                }
                board[row][i] = false;
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        solveNQueens(new boolean[n][n], 0, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
