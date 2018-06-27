package org.problems.dp;

//https://leetcode.com/problems/guess-number-higher-or-lower-ii/description/
public class GuessNumberHigherorLower {

    private static int getMoneyAmount(int lo, int hi, int[][] dp) {
        if (lo >= hi)
            return 0;
        if (dp[lo][hi] != 0)
            return dp[lo][hi];

        dp[lo][hi] = Integer.MAX_VALUE;
        for (int i = (hi + lo) / 2; i < hi; ++i) {
            dp[lo][hi] = Math.min(dp[lo][hi], i + Math.max(getMoneyAmount(lo, i - 1, dp), getMoneyAmount(i + 1, hi, dp)));
        }
        return dp[lo][hi];
    }


    public static int getMoneyAmount(int n) {
        return getMoneyAmount(0, n, new int[n + 1][n + 1]);
    }

    public static void main(String[] args) {
        System.out.println(getMoneyAmount(10) == 16);
        System.out.println(getMoneyAmount(4) == 4);
    }
}
