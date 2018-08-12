package org.problems.dp;

//https://leetcode.com/problems/profitable-schemes/description/
public class ProfitableSchemes {

    public static int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int M = 1000000007;
        int N = group.length;
        long[][][] dp = new long[N + 1][P + 1][G + 1];
        dp[0][0][0] = 1;

        for (int i = 1; i <= N; ++i) {
            int p0 = profit[i - 1];
            int g0 = group[i - 1];

            for (int jp = 0; jp <= P; ++jp)
                for (int jg = 0; jg <= G; ++jg)
                    dp[i][jp][jg] = dp[i - 1][jp][jg];

            for (int p1 = 0; p1 <= P; ++p1) {
                int p2 = Math.min(P, p0 + p1);
                for (int g1 = 0; g1 <= G - g0; ++g1) {
                    int g2 = g0 + g1;
                    dp[i][p2][g2] += dp[i - 1][p1][g1];
                    dp[i][p2][g2] %= M;
                }
            }
        }

        long res = 0;
        for (int i = 0; i <= G; ++i) {
            res += dp[N][P][i];
        }
        return (int) (res % M);
    }

    public static void main(String[] args) {
        System.out.println(profitableSchemes(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8}));
        System.out.println(profitableSchemes(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8}));
    }
}
