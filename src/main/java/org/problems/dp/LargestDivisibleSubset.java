package org.problems.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/largest-divisible-subset/description/
public class LargestDivisibleSubset {

    private static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length < 1)
            return res;
        Arrays.sort(nums);
        int[][] dp = new int[2][nums.length];
        Arrays.fill(dp[1], -1);
        for (int i = 1; i < nums.length; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (nums[i] % nums[j] == 0 && dp[0][j] >= dp[0][i]) {
                    dp[0][i] = dp[0][j] + 1;
                    dp[1][i] = j;
                }
            }
        }
        int[] max = new int[]{Integer.MIN_VALUE, 0};
        for (int i = 1; i < nums.length; ++i) {
            if (dp[0][i] > max[0]) {
                max[0] = dp[0][i];
                max[1] = i;
            }
        }
        int index = max[1];
        while (index != -1) {
            res.add(nums[index]);
            index = dp[1][index];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{4, 8, 10, 240}));
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 4, 8}));
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 3}));
    }
}
