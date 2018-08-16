package org.problems.dp;

import java.util.Arrays;

//https://leetcode.com/problems/dungeon-game/description/
public class DungeonGame {

    public static int calculateMinimumHP(int[][] dungeon) {
        int lo = 1;
        int hi = findUpperBound(dungeon);
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (canGetToEnd(dungeon, mid))
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return lo;
    }

    private static int findUpperBound(int[][] dungeon) {
        long[][] healthMap = new long[dungeon.length + 1][dungeon[0].length + 1];
        Arrays.fill(healthMap[0], Integer.MIN_VALUE);
        healthMap[1][0] = 0;
        healthMap[0][1] = 0;
        long lower = Integer.MAX_VALUE;
        for (int i = 1; i < healthMap.length; ++i) {
            healthMap[i][0] = Integer.MIN_VALUE;
            for (int j = 1; j < healthMap[0].length; ++j) {
                healthMap[i][j] = dungeon[i - 1][j - 1] + Math.max(healthMap[i - 1][j], healthMap[i][j - 1]);
                lower = Math.min(lower, healthMap[i][j]);
            }
        }
        return (int) Math.abs(lower);
    }

    private static boolean canGetToEnd(int[][] dungeon, long health) {
        long[][] dp = new long[dungeon.length + 1][dungeon[0].length + 1];

        Arrays.fill(dp[0], Integer.MIN_VALUE);
        dp[1][0] = health;
        dp[0][1] = health;
        for (int i = 1; i < dp.length; ++i) {
            boolean isContinue = false;
            dp[i][0] = Integer.MIN_VALUE;
            for (int j = 1; j < dp[0].length; ++j) {
                if (dp[i - 1][j] > 0)
                    dp[i][j] = Math.max(dp[i][j], dungeon[i - 1][j - 1] + dp[i - 1][j]);
                if (dp[i][j - 1] > 0)
                    dp[i][j] = Math.max(dp[i][j], dungeon[i - 1][j - 1] + dp[i][j - 1]);
                isContinue |= dp[i][j] > 0;
            }
            if (!isContinue)
                return false;
        }
        return dp[dp.length - 1][dp[0].length - 1] > 0;
    }

    public static void main(String[] args) {
        System.out.println(calculateMinimumHP(new int[][]{{-200}}));
        System.out.println(calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
    }
}
