package org.problems.dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class BestTimeBuySellStock {

    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int result = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] <= min) {
                min = prices[i];
            } else {
                result = Math.max(result, prices[i] - min);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));
        System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
    }
}
