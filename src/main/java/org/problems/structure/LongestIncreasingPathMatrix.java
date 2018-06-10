package org.problems.structure;

//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
public class LongestIncreasingPathMatrix {

    private static int dfs1(int[][] m, int i, int j, int val, int[][] mem) {
        if (i >= 0 && i < m.length && j >= 0 && j < m[0].length && m[i][j] > val) {
            if (mem[i][j] != 0)
                return mem[i][j];
            mem[i][j] = Math.max(dfs1(m, i, j - 1, m[i][j], mem), dfs1(m, i, j + 1, m[i][j], mem));
            mem[i][j] = Math.max(mem[i][j], dfs1(m, i - 1, j, m[i][j], mem));
            mem[i][j] = Math.max(mem[i][j], dfs1(m, i + 1, j, m[i][j], mem));
            return ++mem[i][j];
        }
        return 0;
    }

    private static int dfs(int[][] m, int i, int j, int[][] mem) {
        if (mem[i][j] != 0)
            return mem[i][j];

        if (j - 1 >= 0 && m[i][j - 1] > m[i][j])
            mem[i][j] = Math.max(mem[i][j], dfs(m, i, j - 1, mem));
        if (j + 1 < m[0].length && m[i][j + 1] > m[i][j])
            mem[i][j] = Math.max(mem[i][j], dfs(m, i, j + 1, mem));
        if (i - 1 >= 0 && m[i - 1][j] > m[i][j])
            mem[i][j] = Math.max(mem[i][j], dfs(m, i - 1, j, mem));
        if (i + 1 < m.length && m[i + 1][j] > m[i][j])
            mem[i][j] = Math.max(mem[i][j], dfs(m, i + 1, j, mem));
        return ++mem[i][j];
    }

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int result = 0;
        int[][] mem = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (mem[i][j] == 0) {
                    result = Math.max(result, dfs(matrix, i, j, mem));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestIncreasingPath(new int[][]{
                {7, 6, 1, 1},
                {2, 7, 6, 0},
                {1, 3, 5, 1},
                {6, 6, 3, 2}}) == 7);

        System.out.println(longestIncreasingPath(new int[][]{
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}}) == 4);
        System.out.println(longestIncreasingPath(new int[][]{{1, 2}}) == 2);
        System.out.println(longestIncreasingPath(new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}}) == 4);
    }
}
