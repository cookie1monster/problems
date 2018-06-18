package org.problems.dp;

//https://leetcode.com/problems/strange-printer/description/
public class StrangePrinter {

    private static int strangePrinter(char[] s, int i, int j, int[][] dp) {
        if (i > j)
            return 0;
        if (dp[i][j] > 0)
            return dp[i][j];

        for (; i < j && s[i] == s[i + 1]; ++i) ;
        int res = 1 + strangePrinter(s, i + 1, j, dp);
        for (int m = i + 1; m <= j; ++m) {
            if (s[i] == s[m])
                res = Math.min(res, strangePrinter(s, i + 1, m - 1, dp) + strangePrinter(s, m, j, dp));
        }
        dp[i][j] = res;
        return res;
    }

    public static int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        return strangePrinter(s.toCharArray(), 0, n - 1, dp);
    }

    public static void main(String[] args) {
        System.out.println(strangePrinter("aba"));
        System.out.println(strangePrinter("aaabbb"));
    }
}
