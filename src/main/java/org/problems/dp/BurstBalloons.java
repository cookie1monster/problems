package org.problems.dp;

//https://leetcode.com/problems/burst-balloons/description/
public class BurstBalloons {

    public static int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[][] memo = new int[nums.length][nums.length];

        for (int len = 1; len <= nums.length; ++len) {
            for (int start = 0; start <= nums.length - len; ++start) {
                int end = start + len - 1;
                for (int i = start; i <= end; ++i) {
                    int cost = (start == 0 ? 1 : nums[start - 1]) * nums[i] * (end == nums.length - 1 ? 1 : nums[end + 1]);
                    cost += (i == start ? 0 : memo[start][i - 1]);
                    cost += (i == end ? 0 : memo[i + 1][end]);
                    memo[start][end] = Math.max(memo[start][end], cost);
                }
            }
        }
        return memo[0][nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3, 1, 5, 8}) == 167);
    }
}
