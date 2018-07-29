package org.problems.dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
public class BestTimeBuySellStock2 {

    public static int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;

        int profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i - 1] < prices[i])
                profit += prices[i] - prices[i - 1];
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 2, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}) == 0);
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 9}) == 10);
    }
}
