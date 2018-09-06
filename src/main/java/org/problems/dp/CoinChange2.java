package org.problems.dp;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change-2/description/
public class CoinChange2 {

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; ++i) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5};
        System.out.println(coinChange(arr, 5));
    }
}
