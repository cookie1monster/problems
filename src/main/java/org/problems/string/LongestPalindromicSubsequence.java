package org.problems.string;

//https://leetcode.com/problems/longest-palindromic-subsequence/description/
public class LongestPalindromicSubsequence {

    public static int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = s.length() - 1; j >= 0; --j) {
                if (s.charAt(i - 1) == s.charAt(j))
                    dp[i][j] = 1 + dp[i - 1][j + 1];
                else
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i - 1][j]);
            }
        }
        return dp[s.length()][0];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("abcbba") == 5);
        System.out.println(longestPalindromeSubseq("bbbab") == 4);
        System.out.println(longestPalindromeSubseq("aabaaba") == 6);
        System.out.println(longestPalindromeSubseq("cbba") == 2);
    }
}
