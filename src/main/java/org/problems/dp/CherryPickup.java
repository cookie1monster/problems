package org.problems.dp;

import java.util.Arrays;

//https://leetcode.com/problems/cherry-pickup/description/
//NOT WORKING
public class CherryPickup {

    public static int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // 1-up 0-right
        int[][] path = new int[n + 1][m + 1];

        int[][] dp = new int[n + 1][m + 1];
        Arrays.fill(dp[0], -1);
        for (int i = 1; i <= n; ++i) {
            dp[i][0] = -1;
            for (int j = 1; j <= m; ++j) {
                if (grid[i - 1][j - 1] == -1) {
                    dp[i][j] = -1;
                    path[i][j] = -1;
                    continue;
                }
                if (dp[i - 1][j] != -1) {
                    dp[i][j] = dp[i - 1][j];
                    path[i][j] = 1;
                }
                if (dp[i][j - 1] != -1 && dp[i][j - 1] > dp[i][j]) {
                    dp[i][j] = dp[i][j - 1];
                    path[i][j] = 0;
                }
                dp[i][j] += grid[i - 1][j - 1];

            }
        }
        if (dp[n][m] == 0 || !markVisitedCell(grid, path))
            return 0;
        int cherries = dp[n][m];

        dp = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                if (grid[i][j] == -1) {
                    dp[i][j] = -1;
                    continue;
                }
                if (dp[i + 1][j] != -1)
                    dp[i][j] = dp[i + 1][j];

                if (dp[i][j + 1] != -1 && dp[i][j + 1] > dp[i][j])
                    dp[i][j] = dp[i][j + 1];

                dp[i][j] += grid[i][j];
            }
        }

        return cherries + dp[0][0];
    }

    private static boolean markVisitedCell(int[][] grid, int[][] path) {
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i + j > 1) {
            grid[i - 1][j - 1] = 0;
            if (path[i][j] == 1)
                --i;
            else if (path[i][j] == 0)
                --j;
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(cherryPickup(new int[][]{
                {1,1,1,1,0,0,0},
                {0,0,0,1,0,0,0},
                {0,0,0,1,0,0,1},
                {1,0,0,1,0,0,0},
                {0,0,0,1,0,0,0},
                {0,0,0,1,0,0,0},
                {0,0,0,1,1,1,1}}));
        System.out.println(cherryPickup(new int[][]{
                {1, 1, -1, 1, 1},
                {-1, 1, 1, 1, 1},
                {1, -1, -1, 1, 1},
                {1, -1, 1, 1, -1},
                {1, 1, 1, -1, 1}}));
        System.out.println(cherryPickup(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 1, 1}}));
    }
}
