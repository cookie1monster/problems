package org.problems.graph;

//https://leetcode.com/problems/shortest-path-to-get-all-keys/description/
public class ShortestPathtoGetAllKeys {

    // NO SOLUTION
    public static int dfs(int[][] matrix, int i, int j) {
        if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length && matrix[i][j] == 1) {
            matrix[i][j] = 2;
            return 1 + dfs(matrix, i - 1, j - 1)
                    + dfs(matrix, i - 1, j)
                    + dfs(matrix, i - 1, j + 1)
                    + dfs(matrix, i, j - 1)
                    + dfs(matrix, i, j + 1)
                    + dfs(matrix, i + 1, j - 1)
                    + dfs(matrix, i + 1, j)
                    + dfs(matrix, i + 1, j + 1);
        }
        return 0;
    }

    public static int shortestPathAllKeys(String[] grid) {
        char[][] g = new char[grid.length][grid[0].length()];
        for (int i = 0; i < grid.length; ++i) {
            g[i] = grid[i].toCharArray();
        }

        return 0;
    }

    public static void main(String[] args) {

    }
}
