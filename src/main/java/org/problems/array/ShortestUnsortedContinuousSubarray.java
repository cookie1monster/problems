package org.problems.array;

//https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
public class ShortestUnsortedContinuousSubarray {

    public static int findUnsortedSubarray(int[] nums) {
        int hi = nums.length - 1;
        while (hi > 0 && nums[hi] >= nums[hi - 1])
            --hi;

        if (hi == 0)
            return 0;

        int i = hi;
        while (hi < nums.length - 1 && i >= 0) {
            if (nums[i] <= nums[hi + 1])
                --i;
            else
                ++hi;
        }

        int lo = 0;
        while (lo < nums.length - 1 && nums[lo] <= nums[lo + 1])
            ++lo;

        i = lo;
        while (lo > 0 && i < nums.length) {
            if (nums[i] >= nums[lo - 1])
                ++i;
            else
                --lo;
        }

        return hi - lo + 1;
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{1}) == 0);
        System.out.println(findUnsortedSubarray(new int[]{5, 6, 4, 8, 10, 9, 15}) == 6);
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}) == 5);
        System.out.println(findUnsortedSubarray(new int[]{3, 1, 2}) == 3);
    }
}
