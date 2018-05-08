package org.problems.dp;

import java.util.Arrays;

//https://leetcode.com/problems/partition-equal-subset-sum/description/
public class PartitionEqualSubsetSum {

    public static boolean canPartition1(int[] nums) {
        int amount = 0;
        for (int num : nums)
            amount += num;

        if (amount % 2 == 1)
            return false;

        amount /= 2;

        int[] dp = new int[amount + 1];
        boolean[][] used = new boolean[amount + 1][nums.length + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < nums.length; ++j) {
                if (nums[j] <= i && !used[i - nums[j]][j] && dp[i] > 1 + dp[i - nums[j]]) {
                    dp[i] = 1 + dp[i - nums[j]];
                    for (int l = 0; l < used[i].length; ++l)
                        used[i][l] = used[i - nums[j]][l];
                    used[i][j] = true;
                }
            }
            if (dp[amount] <= amount)
                return true;
        }
        return false;
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 == 1)
            return false;
        sum /= 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums)
            for (int i = sum; i >= num; --i) {
                dp[i] = dp[i] || dp[i - num];
                if (dp[sum])
                    return true;
            }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{5, 11, 5, 1}));
        System.out.println(canPartition(new int[]{2, 2, 3, 5}));
        System.out.println(canPartition(new int[]{1, 6, 10, 7}));
        System.out.println(canPartition(new int[]{1, 6, 10, 5}));
        System.out.println(canPartition(new int[]{1, 2, 3, 5}));
    }
}
