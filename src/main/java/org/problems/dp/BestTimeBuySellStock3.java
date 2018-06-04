package org.problems.dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
public class BestTimeBuySellStock3 {

    public static int maxProfit(int[] prices) {
        if (prices.length < 1)
            return 0;
        int[] dp1 = new int[prices.length];
        int[] dp2 = new int[prices.length];


        int min = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            dp1[i] = Math.max(dp1[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        if (dp1[prices.length - 1] == 0)
            return 0;

        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; --i) {
            dp2[i] = Math.max(dp2[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }

        int res = 0;
        for (int i = 0; i < prices.length; ++i)
            res = Math.max(res, dp1[i] + dp2[i]);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{6, 1, 3, 2, 4, 7}) == 7);
        System.out.println(maxProfit(new int[]{2, 1, 4, 5, 2, 9, 7}) == 11);
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}) == 6);
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}) == 4);
    }
}
