package org.problems.dp;

//https://leetcode.com/problems/split-array-largest-sum/description/
public class SplitArrayLargestSum2 {

    public static int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] memo = new int[n + 1][m + 1];
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < nums.length; ++i)
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        return splitArray(nums, 0, m, prefixSum, memo);
    }

    private static int splitArray(int[] nums, int n, int m, int[] prefixSum, int[][] memo) {
        if (m == 1)
            return prefixSum[nums.length] - prefixSum[n];

        if (memo[n][m] != 0)
            return memo[n][m];

        int limit = prefixSum[nums.length] - prefixSum[n];
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = n; i < nums.length - m + 1; ++i) {
            sum += nums[i];
            if (sum > limit)
                break;
            ans = Math.min(ans,
                    Math.max(sum,
                            splitArray(nums, i + 1, m - 1, prefixSum, memo)));
        }
        memo[n][m] = ans;
        return memo[n][m];
    }

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{10, 5, 13, 4, 8, 4, 5, 11, 14, 9, 16, 10, 20, 8}, 8));//25
        System.out.println(splitArray(new int[]{2, 3, 1, 2, 4, 3}, 5));//4
        System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 2));//18
    }
}
