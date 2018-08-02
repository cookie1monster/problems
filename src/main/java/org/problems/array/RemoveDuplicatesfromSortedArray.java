package org.problems.array;

import java.util.Arrays;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
public class RemoveDuplicatesfromSortedArray {

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static int removeDuplicates1(int[] nums) {
        if (nums.length < 1)
            return 0;
        int uniqueNumber = 1;
        for (int i = 1; i < nums.length; ++i)
            if (nums[i - 1] != nums[i])
                ++uniqueNumber;

        int lo = 1;
        int to = lo;
        int hi = nums.length - 1;
        while (lo < hi) {
            if (to == lo) {
                while (lo < hi && nums[lo - 1] != nums[lo])
                    ++lo;

                to = lo;
                while (to < hi && nums[to - 1] == nums[to])
                    ++to;
            }

            while (lo < hi && nums[hi - 1] == nums[hi])
                --hi;

            swap(nums, lo, hi);
            ++lo;
            --hi;
        }
        Arrays.sort(nums, 0, uniqueNumber);
        return uniqueNumber;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length < 1)
            return 0;

        int index = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[index]) {
                ++index;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{-50, -50, -49, -48, -47, -47, -47, -46, -45, -43, -42, -41, -40, -40, -40, -40, -40, -40, -39, -38, -38, -38, -38, -37, -36, -35, -34, -34, -34, -33, -32, -31, -30, -28, -27, -26, -26, -26, -25, -25, -24, -24, -24, -22, -22, -21, -21, -21, -21, -21, -20, -19, -18, -18, -18, -17, -17, -17, -17, -17, -16, -16, -15, -14, -14, -14, -13, -13, -12, -12, -10, -10, -9, -8, -8, -7, -7, -6, -5, -4, -4, -4, -3, -1, 1, 2, 2, 3, 4, 5, 6, 6, 7, 8, 8, 9, 9, 10, 10, 10, 11, 11, 12, 12, 13, 13, 13, 14, 14, 14, 15, 16, 17, 17, 18, 20, 21, 22, 22, 22, 23, 23, 25, 26, 28, 29, 29, 29, 30, 31, 31, 32, 33, 34, 34, 34, 36, 36, 37, 37, 38, 38, 38, 39, 40, 40, 40, 41, 42, 42, 43, 43, 44, 44, 45, 45, 45, 46, 47, 47, 47, 47, 48, 49, 49, 49, 50}));
        System.out.println(removeDuplicates(new int[]{-3, -1, 0, 0, 0, 3, 3}));
        System.out.println(removeDuplicates(new int[]{1, 1, 1}));
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
