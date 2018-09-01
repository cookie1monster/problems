package org.problems.structure;

import java.util.BitSet;

//https://leetcode.com/problems/falling-squares/description/
public class SolveSudoku {

    static BitSet[] row;
    static BitSet[] col;
    static BitSet[][] box;

    public static void solveSudoku(char[][] board) {
        int n = board.length;
        row = new BitSet[n];
        col = new BitSet[n];
        box = new BitSet[3][3];
        for (int r = 0; r < n; ++r)
            row[r] = new BitSet(n);

        for (int c = 0; c < n; ++c)
            col[c] = new BitSet(n);

        for (int r = 0; r < 3; ++r)
            for (int c = 0; c < 3; ++c)
                box[r][c] = new BitSet(n);

        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                if (board[r][c] == '.') continue;
                int val = (board[r][c] - '1');
                row[r].set(val);
                col[c].set(val);
                box[r / 3][c / 3].set(val);
            }
        }
        dfs(board);
    }

    private static boolean dfs(char[][] board) {
        int n = board.length;
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                if (board[r][c] != '.') continue;
                for (int i = 0; i < 9; ++i) {

                    if (!row[r].get(i) && !col[c].get(i) && !box[r / 3][c / 3].get(i)) {
                        board[r][c] = (char) ('0' + i + 1);

                        row[r].set(i);
                        col[c].set(i);
                        box[r / 3][c / 3].set(i);

                        if (dfs(board))
                            return true;

                        board[r][c] = '.';
                        row[r].clear(i);
                        col[c].clear(i);
                        box[r / 3][c / 3].clear(i);
                    }
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(board);
        int n = board.length;
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }
}
