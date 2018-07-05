package org.problems.dp;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-length-of-pair-chain/description/
public class MaximumLengthofPairChain2 {

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (x, y) -> {
            if (x[0] == y[0])
                return x[1] - y[1];
            return x[0] - y[0];
        });
        int res = 0;
        int[] dp = new int[pairs.length];
        for (int i = 0; i < pairs.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (pairs[i][0] > pairs[j][1])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            res = Math.max(res, dp[i] + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findLongestChain(new int[][]{{1, 2}, {1, 3}, {2, 3}, {4, 5}}));
        System.out.println(findLongestChain(new int[][]{{-10, -8}, {8, 9}, {-5, 0}, {6, 10}, {-6, -4}, {1, 7}, {9, 10}, {-4, 7}}));
        System.out.println(findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }
}
