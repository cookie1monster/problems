package org.problems.dp;

import java.util.Arrays;

//https://leetcode.com/problems/russian-doll-envelopes/description/
public class RussianDollEnvelopes {

    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (x, y) -> x[1] - y[1]);
        int[] dp = new int[envelopes.length];
        int res = 0;
        for (int i = 0; i < envelopes.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i] + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxEnvelopes(new int[][]{{46, 89}, {50, 53}, {52, 68}, {72, 45}, {77, 81}}));
        System.out.println(maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}) == 3);
    }
}
