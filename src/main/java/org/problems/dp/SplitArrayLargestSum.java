package org.problems.dp;

//https://leetcode.com/problems/split-array-largest-sum/description/
public class SplitArrayLargestSum {

    private static long splitArray(int[] nums, long[] pre, int n, int m, Long[][] dp) {
        if (m == 1)
            return pre[n];

        if (dp[n][m] != null && dp[n][m] != -1)
            return dp[n][m];

        long sum = 0;
        long res = pre[n];
        for (int i = 1; i < n - m + 2; ++i) {
            sum += nums[n - i];
            if (sum > res)
                break;
            res = Math.min(res, Math.max(splitArray(nums, pre, n - i, m - 1, dp), sum));
        }

        dp[n][m] = res;
        return dp[n][m];
    }

    public static int splitArray(int[] nums, int m) {
        int n = nums.length;
        Long[][] dp = new Long[n + 1][m + 1];
        long[] pre = new long[n + 1];

        for (int i = 1; i <= n; ++i)
            pre[i] = pre[i - 1] + nums[i - 1];

        return (int) splitArray(nums, pre, n, m, dp);
    }

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{10, 5, 13, 4, 8, 4, 5, 11, 14, 9, 16, 10, 20, 8}, 8) == 25);
        System.out.println(splitArray(new int[]{2, 3, 1, 2, 4, 3}, 5) == 4);
        System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 2) == 18);
    }
}
