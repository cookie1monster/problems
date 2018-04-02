package org.problems.easy;

import java.util.Arrays;
import java.util.stream.Collectors;

//https://leetcode.com/problems/rotate-array/description/
public class RotateArray {

    private static void reverse(int[] nums, int lo, int hi) {
        int temp;
        while (lo<hi) {
            temp = nums[hi];
            nums[hi] = nums[lo];
            nums[lo] = temp;
            ++lo;
            --hi;
        }
    }
    public static void rotate(int[] nums, int k) {
        if (nums.length < 2){
            return;
        }
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        rotate(arr, 4);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }
}
