package org.problems.dp;

//https://leetcode.com/problems/maximum-subarray/description/
public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int result = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            currSum += nums[i];
            currSum = Math.max(currSum, nums[i]);
            result = Math.max(result, currSum);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(arr));
    }
}
