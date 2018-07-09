package org.problems.dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
public class BestTimeBuySellStock4 {

    private static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i - 1] < prices[i])
                profit += prices[i] - prices[i - 1];
        }
        return profit;
    }

    public static int maxProfit(int K, int[] prices) {
        if (prices.length < 2 || K < 1)
            return 0;

        if (K > (prices.length - 1) / 2)
            return maxProfit(prices);

        int[][] dp = new int[K + 1][prices.length];

        for (int k = 1; k <= K; ++k) {
            int min = prices[0];
            for (int i = 1; i < prices.length; ++i) {
                min = Math.min(min, prices[i] - dp[k - 1][i - 1]);
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
            }
        }
        return dp[K][dp[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[]{3, 3, 5, 0, 0, 3, 1, 4}) == 6);
        System.out.println(maxProfit(1, new int[]{3, 3, 5, 0, 0, 3, 1, 4}) == 4);
        System.out.println(maxProfit(3, new int[]{3, 3, 5, 0, 0, 3, 1, 4}) == 8);
        System.out.println(maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}) == 7);
    }
}
