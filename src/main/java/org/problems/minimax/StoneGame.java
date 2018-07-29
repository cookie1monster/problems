package org.problems.minimax;

//https://leetcode.com/problems/stone-game/description/
public class StoneGame {

    public static boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }

    public static void main(String[] args) {
        System.out.println(stoneGame(new int[]{5, 3, 4, 5}));
    }
}
