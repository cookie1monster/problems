package org.problems.dp;

//https://leetcode.com/problems/min-cost-climbing-stairs/description/
public class RangeSumQueryImmutable {

    public static void main(String[] args) {
        System.out.println(new NumArray(new int[]{-2, 0, 3, -5, 2, -1}).sumRange(2, 5));
    }

    static class NumArray {

        private int[] dp;

        public NumArray(int[] nums) {
            dp = new int[nums.length + 1];
            for (int i = 0; i < nums.length; ++i) {
                dp[i + 1] = dp[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return dp[j + 1] - dp[i];
        }
    }
}
