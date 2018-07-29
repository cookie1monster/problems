package org.problems.minimax;

//https://leetcode.com/problems/predict-the-winner/description/
public class PredictWinner {

    private static int predictTheWinner(int[] nums, int lo, int hi, int turn) {
        if (lo == hi)
            return turn * nums[lo];
        int x = turn * nums[lo] + predictTheWinner(nums, lo + 1, hi, -turn);
        int y = turn * nums[hi] + predictTheWinner(nums, lo, hi - 1, -turn);
        return turn * Math.max(turn * x, turn * y);
    }

    public static boolean predictTheWinner(int[] nums) {
        return predictTheWinner(nums, 0, nums.length - 1, 1) >= 0;
    }

    public static void main(String[] args) {
        System.out.println(predictTheWinner(new int[]{1, 5, 233, 7}));
        System.out.println(predictTheWinner(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
