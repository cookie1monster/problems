package org.problems.dp;

import java.util.Arrays;

//https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
public class CheapestFlightsWithinKStops {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] flightsBoard = new int[n][n];
        int[][] dp = new int[K + 1][n];

        for (int i = 0; i < flights.length; ++i)
            flightsBoard[flights[i][0]][flights[i][1]] = flights[i][2];

        for (int i = 0; i < n; ++i)
            dp[0][i] = (flightsBoard[src][i] == 0) ? Integer.MAX_VALUE : flightsBoard[src][i];

        for (int k = 1; k <= K; ++k) {
            dp[k] = Arrays.copyOf(dp[k - 1], n);
            for (int from = 0; from < n; ++from) {
                for (int to = 0; to < n; ++to) {
                    if (to != from && flightsBoard[from][to] > 0 && dp[k - 1][from] != Integer.MAX_VALUE) {
                        dp[k][to] = Math.min(dp[k][to], dp[k - 1][from] + flightsBoard[from][to]);
                    }
                }
            }
        }
        return (dp[K][dst] == Integer.MAX_VALUE) ? -1 : dp[K][dst];
    }

    public static void main(String[] args) {
        System.out.println(findCheapestPrice(4, new int[][]{{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}}, 0, 3, 1));
        System.out.println(findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
    }
}
