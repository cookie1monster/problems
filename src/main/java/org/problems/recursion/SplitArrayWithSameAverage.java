package org.problems.recursion;

import java.util.Arrays;

//https://leetcode.com/problems/split-array-with-same-average/description/
public class SplitArrayWithSameAverage {

    private static boolean splitArraySameAverage(int[] arr, int used, int sum, int start, double targetAvg) {
        double curAvg = 1. * sum / used;
        if (curAvg < targetAvg)
            return false;
        if (arr.length != used && (curAvg - targetAvg) < 0.0001)
            return true;

        for (int i = start; i < arr.length - 1; ++i) {
            if (i > start && arr[i] == arr[i - 1]) continue;
            if (splitArraySameAverage(arr, used - 1, sum - arr[i], i + 1, targetAvg))
                return true;
        }
        return false;
    }

    public static boolean splitArraySameAverage(int[] A) {
        if (A.length < 2) return false;
        Arrays.sort(A);
        int sum = 0;
        for (int num : A)
            sum += num;
        return splitArraySameAverage(A, A.length, sum, 0, 1. * sum / A.length);
    }

    public static void main(String[] args) {
        System.out.println(splitArraySameAverage(new int[]{5, 3, 11, 19, 2}) == true);
        System.out.println(splitArraySameAverage(new int[]{0, 13, 13, 7, 5, 0, 10, 19, 5}) == true);
        System.out.println(splitArraySameAverage(new int[]{6, 8, 18, 3, 1}) == false);
        System.out.println(splitArraySameAverage(new int[]{1, 2, 3, 4, 5, 6, 7, 8}) == true);
    }
}
