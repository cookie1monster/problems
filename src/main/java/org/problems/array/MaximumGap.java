package org.problems.array;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-gap/description/
public class MaximumGap {

    public static int maximumGap(int[] nums) {
        if (nums.length < 2)
            return 0;
        Arrays.sort(nums);
        int max = nums[1] - nums[0];
        for (int i = 2; i < nums.length; ++i) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maximumGap(new int[]{3, 6, 9, 1}));
    }
}
