package org.problems.dp;

//https://leetcode.com/problems/maximum-product-subarray/description/
public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int min = 1;
        int max = 1;
        int oldMax = 1;
        for (int i = 0; i < nums.length; ++i) {
            max = Math.max(max * nums[i], Math.max(nums[i], min * nums[i]));
            min = Math.min(min * nums[i], Math.min(nums[i], oldMax * nums[i]));
            oldMax = max;
            result = Math.max(result, max);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[] { -4, -3, -2 }));
        System.out.println(maxProduct(new int[] { -2, 0, -1 }));
        System.out.println(maxProduct(new int[] { -2, 3, -4 }));
        System.out.println(maxProduct(new int[] { 1, -2, -3, 0, 7, -8, -2 }));
        System.out.println(maxProduct(new int[] { 2, 3, -2, 4 }));
    }
}
