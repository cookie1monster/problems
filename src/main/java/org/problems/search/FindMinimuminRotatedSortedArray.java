package org.problems.search;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
public class FindMinimuminRotatedSortedArray {

    private static int binarySearch(int[] arr, int lo, int hi) {
        int mid = (lo + hi) / 2;
        if (hi - lo < 3)
            return Math.min(arr[mid], Math.min(arr[lo], arr[hi]));

        if (arr[lo] <= arr[mid] && arr[mid] <= arr[hi])
            return arr[lo];

        if (arr[lo] >= arr[mid])
            return binarySearch(arr, lo, mid);
        else
            return binarySearch(arr, mid, hi);
    }

    public static int findMin1(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    // Non recursion version
    public static int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (Math.abs(lo - hi) > 1) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi])
                lo = mid;
            else if (nums[lo] > nums[mid])
                hi = mid;
            else
                return nums[lo];
        }
        return Math.min(nums[lo], nums[hi]);
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{5, 1, 2, 3, 4}) == 1);
        System.out.println(findMin(new int[]{4, 5, 1, 2, 3}) == 1);
        System.out.println(findMin(new int[]{0, 1, 2, 4, 5, 6, 7}) == 0);
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}) == 1);
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}) == 0);
    }
}
