package org.problems.recursion;

import java.util.Arrays;

//https://leetcode.com/problems/matchsticks-to-square/description/
public class MatchsticksSquare2 {

    private static boolean makesquare(int[] nums, int side, int[] sum, int index) {
        if (index == -1)
            return true;
        for (int i = 0; i < 4; ++i) {
            if (sum[i] + nums[index] > side) continue;
            sum[i] += nums[index];
            if (makesquare(nums, side, sum, index - 1))
                return true;
            sum[i] -= nums[index];
        }
        return false;
    }

    public static boolean makesquare(int[] nums) {
        if (nums.length == 0)
            return false;

        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums)
            sum += num;

        int side = sum / 4;
        if (sum % 4 != 0 || nums[nums.length - 1] > side)
            return false;

        return makesquare(nums, side, new int[4], nums.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(makesquare(new int[]{3, 3, 3, 3, 4}));
        System.out.println(makesquare(new int[]{1, 1, 2, 2, 2}));
        System.out.println(makesquare(new int[]{5, 5, 5, 5, 16, 4, 4, 4, 4, 4, 3, 3, 3, 3, 4}));
    }
}
