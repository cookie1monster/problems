package org.problems.dp;

//https://leetcode.com/problems/longest-increasing-subsequence/description/
public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        int longestLeng;
        for (int i = 1; i < dp.length; i++) {
            longestLeng = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    longestLeng = Math.max(longestLeng, dp[j]);
                }
            }
            dp[i] = longestLeng + 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] { 5, 2, 3, 1, 0, 8 }));
    }
}
