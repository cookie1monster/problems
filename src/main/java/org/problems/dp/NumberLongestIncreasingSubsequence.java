package org.problems.dp;

//https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
public class NumberLongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int qnt = 0;
        int result = 0;
        int[] dp = new int[nums.length];
        int[] count = new int[dp.length];
        for (int i = 0; i < nums.length; ++i) {
            count[i] = 1;
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    if (dp[i] < dp[j] + 1) {
                        ++dp[i];
                        count[i] = count[j];
                    } else if (dp[j] == dp[i] - 1) {
                        count[i] += count[j];
                    }
                }
            }
            if (dp[i] > qnt) {
                result = count[i];
                qnt = dp[i];
            } else if (dp[i] == qnt) {
                result += count[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2}));
        System.out.println(lengthOfLIS(new int[]{1, 3, 5, 4, 7, 7}));
        System.out.println(lengthOfLIS(new int[]{2, 2, 2, 2, 2}));
    }
}
