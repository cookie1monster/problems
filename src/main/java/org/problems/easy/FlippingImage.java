package org.problems.easy;

import java.util.Arrays;

//https://leetcode.com/contest/weekly-contest-84/problems/flipping-an-image/
public class FlippingImage {

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; ++i) {
            reverse(A[i]);
            for (int j = 0; j < A.length; ++j) {
                A[i][j] = (A[i][j] == 1) ? 0 : 1;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}})));

    }
}
