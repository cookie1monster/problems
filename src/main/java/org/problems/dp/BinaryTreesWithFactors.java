package org.problems.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/binary-trees-with-factors/description/
public class BinaryTreesWithFactors {

    public static int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < A.length; ++i)
            indexMap.put(A[i], i);

        long[] dp = new long[A.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (A[i] % A[j] == 0 && indexMap.containsKey(A[i] / A[j])) {
                    dp[i] += dp[j] * dp[indexMap.get(A[i] / A[j])];
                }
            }
        }
        long ans = 0;
        for (long val : dp)
            ans = (ans + val) % 1_000_000_007;
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(numFactoredBinaryTrees(new int[]{2, 4, 5, 10}));
    }
}
