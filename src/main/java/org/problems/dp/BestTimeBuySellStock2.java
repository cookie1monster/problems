package org.problems.dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
public class BestTimeBuySellStock2 {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length == 0)
            return profit;
        int min = prices[0];
        for (int i = 1; i < prices.length - 1; ++i) {
            if (prices[i] > prices[i + 1] && prices[i] > min) {
                profit += prices[i] - min;
                min = prices[i + 1];
            } else
                min = Math.min(min, prices[i]);
        }
        return profit + ((prices[prices.length - 1] > min) ? prices[prices.length - 1] - min : 0);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 9}));
    }
}
