package org.problems.dp;

import java.util.TreeSet;

//https://leetcode.com/problems/largest-sum-of-averages/description/
public class LargestSumAverages {

    private static double largestSumOfAverages(int[] A, int k, int[] prefix, int start, double[][] dp) {
        if (dp[start][k] != 0) return dp[start][k];
        if (k == 1)
            return ((double) (prefix[A.length] - prefix[start])) / (A.length - start);
        for (int i = start + 1; i <= A.length - k + 1; ++i) {
            dp[start][k] = Math.max(dp[start][k], ((double) (prefix[i] - prefix[start])) / (i - start) + largestSumOfAverages(A, k - 1, prefix, i, dp));
        }
        return dp[start][k];
    }

    public static double largestSumOfAverages(int[] A, int K) {
        double[][] dp = new double[A.length + 1][K + 1];
        int[] prefix = new int[A.length + 1];
        for (int i = 0; i < A.length; ++i)
            prefix[i + 1] = prefix[i] + A[i];

        return largestSumOfAverages(A, K, prefix, 0, dp);
    }

    public static void main(String[] args) {

        TreeSet t= new TreeSet();

        System.out.println(largestSumOfAverages(new int[]{9}, 1));
        System.out.println(largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3));
        System.out.println(largestSumOfAverages(new int[]{9, 9, 1, 2, 3}, 3));
    }
}
