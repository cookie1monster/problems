package org.problems.graph;

//https://leetcode.com/problems/word-search/description/
public class WordSearch {

    public static boolean dfs(char[][] board, int i, int j, String word) {
        if (word.length() > 0
                && i >= 0 && i < board.length && j >= 0 && j < board[0].length
                && board[i][j] == word.charAt(0)) {
            board[i][j] = Character.MIN_VALUE;
            boolean result = dfs(board, i - 1, j, word.substring(1))
                            || dfs(board, i + 1, j, word.substring(1))
                            || dfs(board, i, j - 1, word.substring(1))
                            || dfs(board, i, j + 1, word.substring(1));
            board[i][j] = word.charAt(0);
            return result;
        }
        return word.length() == 0;
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (dfs(board, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "ABCB"));
        System.out.println(exist(board, "SEE"));

    }
}
