package org.problems.search;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
public class FindMinimuminRotatedSortedArray3 {

    public static int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (Math.abs(lo - hi) > 1) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi])
                lo = mid;
            else if (nums[lo] > nums[mid])
                hi = mid;
            else if (nums[hi] == nums[lo])
                --hi;
            else
                return nums[lo];
        }
        return Math.min(nums[lo], nums[hi]);
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 3, 1, 3}) == 1);
        System.out.println(findMin(new int[]{0, 1, 2, 4, 5, 6, 7}) == 0);
        System.out.println(findMin(new int[]{5, 1, 2, 3, 4}) == 1);
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}) == 0);
        System.out.println(findMin(new int[]{1, 3, 3, 3}) == 1);
        System.out.println(findMin(new int[]{3, 1, 3, 3}) == 1);
        System.out.println(findMin(new int[]{3, 3, 3, 1}) == 1);
        System.out.println(findMin(new int[]{2, 2, 2, 0, 1}) == 0);
        System.out.println(findMin(new int[]{4, 5, 1, 2, 3}) == 1);
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}) == 1);

    }
}
