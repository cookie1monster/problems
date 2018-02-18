package org.problems.search;

//https://leetcode.com/problems/find-the-duplicate-number/description/
public class FindDuplicateNumber {

    public static boolean binarySearch(int[] nums, int val, int lo, int hi) {
        if (lo > hi)
            return false;
        int mid = (lo + hi) / 2;
        if (nums[mid] == val)
            return true;
        return binarySearch(nums, val, lo, mid - 1) || binarySearch(nums, val, mid + 1, hi);
    }

    public static int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (binarySearch(nums, nums[i], i + 1, nums.length - 1)) {
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] { 4, 2, 8, 1, 3, 5, 8 }));
    }
}
