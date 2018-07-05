package org.problems.array;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-closest/description/
public class TreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int dist = Integer.MAX_VALUE;
        int closestSum = 0;
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; ++i) {
            int lo = 0;
            int hi = i - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi] + nums[i];
                if (Math.abs(sum - target) < dist) {
                    dist = Math.abs(sum - target);
                    closestSum = sum;
                }
                if (sum > target) {
                    --hi;
                } else {
                    ++lo;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1) == 2);
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 2) == 2);
    }
}
