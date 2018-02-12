package org.problems.dp;

import java.util.Arrays;
import java.util.stream.Collectors;

//https://leetcode.com/problems/counting-bits/description/
public class CountingBits {

    public static int[] countBits(int num) {
        int[] dp = new int[num+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i=1; i<=num; i++) {
            for (int j=1; j<=i; j*=2) {
                dp[i] = Math.min(1 + dp[i - j], dp[i]);
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.stream(countBits(5)).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(countBits(9)).boxed().collect(Collectors.toList()));
    }
}
