package org.problems.dp;

import java.util.Arrays;

//https://leetcode.com/problems/distinct-subsequences/description/
public class DistinctSubsequences {

    public static int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        Arrays.fill(dp[0], 1);
        for (int j = 1; j <= t.length(); ++j) {
            for (int i = 1; i <= s.length(); ++i) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j][i] = dp[j - 1][i - 1] + dp[j][i - 1];
                } else {
                    dp[j][i] = dp[j][i - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit") == 3);
        System.out.println(numDistinct("babgbag", "bag") == 5);
    }
}
