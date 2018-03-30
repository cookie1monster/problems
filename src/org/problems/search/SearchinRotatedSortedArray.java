package org.problems.search;

//https://leetcode.com/problems/search-in-rotated-sorted-array/description/
public class SearchinRotatedSortedArray {

    public static int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int step = 1;
        int i = 0;
        if (nums[0] > target) {
            i = nums.length - 1;
            step = -1;
        }
        int temp = nums[i];
        while (i >= 0 && i < nums.length && step * temp <= step * nums[i]) {
            if (nums[i] == target) {
                return i;
            }
            temp = nums[i];
            i += step;
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(arr, 6));
        System.out.println(search(arr, 1));
        System.out.println(search(arr, 3));
    }
}
