package org.problems.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

//https://leetcode.com/problems/wiggle-sort-ii/description/
public class WiggleSort {

    public static void wiggleSort(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        int k = nums.length - 1;
        int l = k / 2;
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (arr[k] < arr[l]) {
                nums[i] = arr[k--];
                nums[i + 1] = arr[l--];
            } else {
                nums[i] = arr[l--];
                nums[i + 1] = arr[k--];
            }
        }
        if (l == 0) {
            nums[nums.length - 1] = (arr[k] < arr[l]) ? arr[k] : arr[l];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 3, 2, 2, 2, 1, 1, 3, 1, 1, 2 };
        wiggleSort(nums);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        nums = new int[] { 1, 3, 2, 2, 3, 1 };
        wiggleSort(nums);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        nums = new int[] { 1, 2, 2, 1, 2, 1, 1, 1, 1, 2, 2, 2 };
        wiggleSort(nums);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        nums = new int[] { 4, 5, 5, 6 };
        wiggleSort(nums);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        nums = new int[] { 1, 3, 2, 2, 2, 1, 1, 3, 1, 1, 2 };
        wiggleSort(nums);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        nums = new int[] { 1, 5, 1, 1, 6, 4 };
        wiggleSort(nums);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }
}
