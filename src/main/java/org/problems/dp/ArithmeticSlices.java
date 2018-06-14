package org.problems.dp;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/arithmetic-slices-ii-subsequence/description/
public class ArithmeticSlices {

    public static int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        long res = 0;
        Map<Integer, Integer>[] dp = new Map[n];

        for (int i = 0; i < n; ++i) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; ++j) {
                long d = (long) A[j] - A[i];
                if (d <= Integer.MIN_VALUE || d >= Integer.MAX_VALUE)
                    continue;
                int delta = (int) d;
                int sum = dp[j].getOrDefault(delta, 0);
                dp[i].put(delta, dp[i].getOrDefault(delta, 0) + sum + 1);
                res += sum;
            }
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{0, 2000000000, -294967296}));
        System.out.println(numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10}) == 7);
    }
}
