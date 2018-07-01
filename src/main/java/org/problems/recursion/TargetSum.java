package org.problems.recursion;

//https://leetcode.com/problems/target-sum/description/
public class TargetSum {

    private static int findTargetSumWays(int[] nums, int sum, int index, Integer[][] memo) {
        if (sum > 2000)
            return 0;
        if (index == nums.length)
            return sum == 0 ? 1 : 0;

        if (memo[index][sum + 1000] != null) {
            return memo[index][sum + 1000];
        }
        memo[index][sum + 1000] = 0;
        memo[index][sum + 1000] += findTargetSumWays(nums, sum - nums[index], index + 1, memo);

        memo[index][sum + 1000] += findTargetSumWays(nums, sum + nums[index], index + 1, memo);
        return memo[index][sum + 1000];
    }

    public static int findTargetSumWays(int[] nums, int S) {
        Integer[][] memo = new Integer[21][3003];
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < S ? 0 : findTargetSumWays(nums, S, 0, memo);
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3) == 5);
    }
}
