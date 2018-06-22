package org.problems.dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
public class BestTimeBuySellStockwithTransactionFee {

    public static int maxProfit(int[] prices, int fee) {
        if (prices.length == 0)
            return 0;
        int profit = 0;
        int hold = -prices[0];

        for (int i = 1; i < prices.length; ++i) {
            profit = Math.max(profit, hold + prices[i] - fee);
            hold = Math.max(hold, profit - prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2) == 8);
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}, 3) == 2);
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 9}, 4) == 4);
    }
}
