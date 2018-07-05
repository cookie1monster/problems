package org.problems.dp;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-length-of-pair-chain/description/
public class MaximumLengthofPairChain {

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (x, y) -> {
            if (x[1] == y[1])
                return x[0] - y[0];
            return x[1] - y[1];
        });
        int res = 0;
        int cur = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (cur < pair[0]) {
                cur = pair[1];
                ++res;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(findLongestChain(new int[][]{{-10, -8}, {8, 9}, {-5, 0}, {6, 10}, {-6, -4}, {1, 7}, {9, 10}, {-4, 7}}));
        System.out.println(findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }
}
