package org.problems.search;

import java.util.Arrays;

//https://leetcode.com/problems/search-for-a-range/description/
public class SearchforRange {

    private static int binarySearch(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = (hi + lo) / 2;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int left = binarySearch(nums, target, true);
        if (left == nums.length || nums[left] != target)
            return result;

        result[0] = left;
        result[1] = binarySearch(nums, target, false) - 1;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 8}, 8)));
    }
}
