package org.problems.dp;

import java.util.Arrays;

//https://leetcode.com/problems/unique-paths/description
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        if (m == 1 && n == 1)
            return 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 1);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 3));
        System.out.println(uniquePaths(2, 2));
        System.out.println(uniquePaths(1, 10));
        System.out.println(uniquePaths(1, 2));
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(11, 23));
    }
}
