package org.problems.dp;

import java.util.Arrays;

public class NumSquares {

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int root = 1; root * root <= i; root++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - root * root]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(42));
    }
}
