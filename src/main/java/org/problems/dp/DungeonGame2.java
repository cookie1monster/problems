package org.problems.dp;

//https://leetcode.com/problems/dungeon-game/description/
public class DungeonGame2 {

    public static int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];

        dp[n - 1][m - 1] = Math.max(1, 1 - dungeon[n - 1][m - 1]);
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                if ((i == n - 1 && j == m - 1)) continue;
                dp[i][j] = Integer.MAX_VALUE;
                if (i != n - 1) dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] - dungeon[i][j]);
                if (j != m - 1) dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] - dungeon[i][j]);
                dp[i][j] = Math.max(0, dp[i][j]);
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        System.out.println(calculateMinimumHP(new int[][]{{0, 0}}));
        System.out.println(calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
        System.out.println(calculateMinimumHP(new int[][]{{-200}}));
    }
}
