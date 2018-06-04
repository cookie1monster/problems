package org.problems.structure;

//https://leetcode.com/problems/swim-in-rising-water/description/
public class SwimRisingWater {

    private static boolean dfs(boolean[][] table, int i, int j, boolean[][] grid) {
        if (i == grid.length - 1 && i == j)
            return true;

        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length
                && table[i][j] && !grid[i][j]) {
            grid[i][j] = true;
            return dfs(table, i - 1, j, grid)
                    || dfs(table, i + 1, j, grid)
                    || dfs(table, i, j - 1, grid)
                    || dfs(table, i, j + 1, grid);
        }
        return false;
    }

    public static int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] index = new int[n * n][2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                index[grid[i][j]][0] = i;
                index[grid[i][j]][1] = j;
            }
        }
        int t = Math.max(grid[0][0], grid[n - 1][n - 1]) + 1;
        boolean[][] table = new boolean[n][n];
        for (int i = 0; i < t; ++i)
            table[index[i][0]][index[i][1]] = true;

        for (; t < n * n; ++t) {
            if (dfs(table, 0, 0, new boolean[n][n])) {
                break;
            }
            table[index[t][0]][index[t][1]] = true;
        }
        return t - 1;
    }

    public static void main(String[] args) {
        System.out.println(swimInWater(new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}));
    }

}
