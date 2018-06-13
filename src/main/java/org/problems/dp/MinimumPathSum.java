package org.problems.dp;

//https://leetcode.com/problems/minimum-path-sum/description/
public class MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 1; i <= grid.length; ++i) {
            for (int j = 1; j <= grid[0].length; ++j) {
                if (i > 1 && j > 1)
                    dp[i][j] = grid[i - 1][j - 1] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                else if (i > 1)
                    dp[i][j] = grid[i - 1][j - 1] + dp[i - 1][j];
                else if (j > 1)
                    dp[i][j] = grid[i - 1][j - 1] + dp[i][j - 1];
                else
                    dp[i][j] = grid[i - 1][j - 1];
            }
        }
        return dp[grid.length][grid[0].length];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{3}}));
        System.out.println(minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}}));
    }
}
