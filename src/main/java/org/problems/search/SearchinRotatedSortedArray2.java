package org.problems.search;

//https://leetcode.com/problems/search-in-rotated-sorted-array/description/
public class SearchinRotatedSortedArray2 {

    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int lo = 0;
        int hi = nums.length-1;

        while (lo + 1 < hi) {
            int mid = (lo+hi) >> 1;
            if (nums[mid] == target)
                return mid;

            if (nums[mid] >= nums[lo]) {
                if (target >= nums[lo] && target <= nums[mid])
                    hi = mid;
                else
                    lo = mid;
            } else {
                if (target <= nums[hi] && target >= nums[mid])
                    lo = mid;
                else
                    hi = mid;
            }
        }
        if (nums[lo] == target) return lo;
        if (nums[hi] == target) return hi;
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(arr, 6));
        System.out.println(search(arr, 1));
        System.out.println(search(arr, 3));
    }
}
