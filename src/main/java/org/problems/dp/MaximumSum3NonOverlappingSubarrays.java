package org.problems.dp;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/description/
public class MaximumSum3NonOverlappingSubarrays {

    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;

        int[] sumA = new int[n];
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            if (i > k - 1) {
                sum -= nums[i - k];
                sumA[i - k + 1] = sum;
            } else if (i == k - 1) {
                sumA[i - k + 1] = sum;
            }
        }

        int[] maxLeft = new int[n];
        maxLeft[0] = sumA[0];
        for (int i = 1; i < n; ++i) {
            maxLeft[i] = Math.max(sumA[i], maxLeft[i - 1]);
        }

        int[] maxRight = new int[n];
        maxRight[n - 1] = sumA[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            maxRight[i] = Math.max(sumA[i], maxRight[i + 1]);
        }

        int iMax = 0;
        int max = Integer.MIN_VALUE;
        for (int i = k; i < n - k; ++i) {
            if (sumA[i] + maxLeft[i - k] + maxRight[i + k] > max) {
                max = sumA[i] + maxLeft[i - k] + maxRight[i + k];
                iMax = i;
            }
        }

        int lMax = iMax - k;
        max = maxLeft[lMax];
        while (lMax >= 0 && maxLeft[lMax] == max)
            --lMax;

        int rMax = iMax + k;
        max = maxRight[rMax];
        while (maxRight[rMax] == max)
            ++rMax;

        return new int[]{++lMax, iMax, --rMax};
    }

    public static void main(String[] args) {
        /*
        [0, 6, 13]
        [1, 4, 7]
        [0, 3, 5]
        */
        System.out.println(Arrays.toString(maxSumOfThreeSubarrays(new int[]{17, 7, 19, 11, 1, 19, 17, 6, 13, 18, 2, 7, 12, 16, 16, 18, 9, 3, 19, 5}, 6)));
        System.out.println(Arrays.toString(maxSumOfThreeSubarrays(new int[]{7, 13, 20, 19, 19, 2, 10, 1, 1, 19}, 3)));
        System.out.println(Arrays.toString(maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2)));
    }
}
