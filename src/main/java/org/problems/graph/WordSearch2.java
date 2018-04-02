package org.problems.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/word-search-ii/description/
public class WordSearch2 {

    public static boolean dfs(char[][] board, int i, int j, String word) {
        if (word.length() > 0 && i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == word
                .charAt(0)) {
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

    public static List<String> findWords(char[][] board, String[] words) {
        Set<String> wordList = new HashSet<>();
        for (int i = 0; i < words.length; ++i) {
            if (wordList.contains(words[i]) || exist(board.clone(), words[i])) {
                wordList.add(words[i]);
            }
        }
        return new ArrayList<>(wordList);
    }

    public static void main(String[] args) {
        char[][] board = new char[][] { { 'o','a','a','n' }, { 'e','t','a','e'}, { 'i','h','k','r' }, { 'i','f','l','v' } };
        System.out.println(findWords(board, new String[]{"aaaaa","oath","pea","eat","rain"}));
    }
}
