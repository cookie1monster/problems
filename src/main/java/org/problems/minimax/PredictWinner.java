package org.problems.minimax;

//https://leetcode.com/problems/predict-the-winner/description/
public class PredictWinner {

    public static boolean predictTheWinner(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length];
        return winner(nums, 0, nums.length - 1, 1, dp) >= 0;
    }

    public static int winner(int[] nums, int s, int e, int turn, Integer[][] dp) {
        if (s == e)
            return turn * nums[s];

        if (dp[s][e] != null)
            return dp[s][e];

        int a = turn * nums[s] + winner(nums, s + 1, e, -turn, dp);
        int b = turn * nums[e] + winner(nums, s, e - 1, -turn, dp);
        if (turn == -1)
            dp[s][e] = Math.min(a, b);
        else
            dp[s][e] = Math.max(a, b);

        return dp[s][e];
    }

    public static void main(String[] args) {
        System.out.println(predictTheWinner(new int[]{1, 5, 233, 7}));
        System.out.println(predictTheWinner(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
