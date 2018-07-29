package org.problems.minimax;

//https://leetcode.com/problems/predict-the-winner/description/
public class PredictWinner2 {

    public static boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                int left = nums[i] - dp[i + 1][j];
                int right = nums[j] - dp[i][j - 1];
                dp[i][j] = Math.max(left, right);
            }
        }
        return dp[0][n - 1] >= 0;
    }

    public static void main(String[] args) {
        System.out.println(predictTheWinner(new int[]{1, 5, 233, 7}));
        System.out.println(predictTheWinner(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
