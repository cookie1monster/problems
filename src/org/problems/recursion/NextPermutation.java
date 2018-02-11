package org.problems.recursion;

import java.util.Arrays;
import java.util.stream.Collectors;

//https://leetcode.com/problems/next-permutation/description/
public class NextPermutation {

    static private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    static private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = i + 1;
            while (j < nums.length && nums[j] >= nums[i]) {
                j++;
            }
            swap(nums, i, j-1);
        }
        reverse(nums, i + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1};
        nextPermutation(arr);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));

        arr = new int[]{1,3,2};
        nextPermutation(arr);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));

        arr = new int[]{2,3,1};
        nextPermutation(arr);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }
}
