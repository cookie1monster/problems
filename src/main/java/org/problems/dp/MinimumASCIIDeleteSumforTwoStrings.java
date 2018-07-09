package org.problems.dp;

//https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/
public class MinimumASCIIDeleteSumforTwoStrings {

    public static int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < dp.length; ++i)
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);

        for (int j = 1; j < dp[0].length; ++j)
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);

        for (int i = 1; i < dp.length; ++i) {
            for (int j = 1; j < dp[0].length; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("sea", ""));
        System.out.println(minimumDeleteSum("sea", "eat"));
        System.out.println(minimumDeleteSum("delete", "leet"));
    }
}
