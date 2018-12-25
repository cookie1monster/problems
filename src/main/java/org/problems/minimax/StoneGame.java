package org.problems.minimax;

//https://leetcode.com/problems/stone-game/description/
public class StoneGame {

    public static boolean stoneGame1(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }

    public static boolean stoneGame(int[] piles) {
        return win(piles, 0, piles.length-1, new Integer[piles.length][piles.length], 1) >= 0;
    }

    private static int win(int[] piles, int lo, int hi, Integer[][] dp, int turn) {
        if (lo == hi)
            return turn * piles[lo];

        if (dp[lo][hi] != null)
            return dp[lo][hi];

        int a = turn * piles[lo] + win(piles, lo+1, hi, dp, -turn);
        int b = turn * piles[hi] + win(piles, lo, hi-1, dp, -turn);

        if (turn == -1)
            dp[lo][hi] = Math.min(a, b);
        else
            dp[lo][hi] = Math.max(a, b);

        return dp[lo][hi];
    }

    public static void main(String[] args) {
        System.out.println(stoneGame(new int[]{5, 3, 4, 5}));
    }
}
