package org.problems.minimax;

//https://leetcode.com/problems/predict-the-winner/description/
public class PredictWinner3 {

    public static boolean predictTheWinner2(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length];

        for (int i = nums.length - 1; i >= 0; --i) {
            for (int j = i + 1; j < nums.length; ++j) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }

    public static boolean predictTheWinner1(int[] nums) {
        int[] dp = new int[nums.length + 1];

        for (int i = nums.length - 1; i >= 0; --i) {
            for (int j = i + 1; j < nums.length; ++j) {
                dp[j + 1] = Math.max(nums[i] - dp[j + 1], nums[j] - dp[j]);
            }
        }
        return dp[nums.length] >= 0;
    }

    public static boolean predictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

        for (int len = 1; len < nums.length; ++len) {
            for (int lo = 0, hi = len; hi < nums.length; ++lo, ++hi) {
                dp[lo][hi] = Math.max(nums[lo] - dp[lo + 1][hi], nums[hi] - dp[lo][hi - 1]);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }

    public static void main(String[] args) {
        System.out.println(predictTheWinner(new int[]{1, 5, 2}));
        System.out.println(predictTheWinner(new int[]{1, 5, 233, 7}));
        System.out.println(predictTheWinner(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
