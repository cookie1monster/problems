package org.problems.dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
public class BestTimeBuySellStockwithCooldown {

    public static int maxProfit(int[] prices) {
        if (prices.length < 1)
            return 0;
        int K = (prices.length + 1) / 3;
        int[][] dp = new int[prices.length + 1][K + 1];

        //dp[k, i] = max(dp[k, i-1], prices[i] - prices[j] + dp[k-1, j-1]), j=[0..i-1]
        for (int k = 1; k <= K; ++k) {
            int min = Math.min(prices[0], prices[1]);
            dp[1][k] = prices[1] - min;
            for (int i = 2; i < prices.length; ++i) {
                min = Math.min(min, prices[i] - dp[i - 2][k - 1]);
                dp[i][k] = Math.max(dp[i - 1][k], prices[i] - min);
            }
        }
        return Math.max(dp[dp.length - 1][K], dp[dp.length - 2][K]);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
