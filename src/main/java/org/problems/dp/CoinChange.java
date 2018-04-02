package org.problems.dp;

//https://leetcode.com/problems/coin-change/description
public class CoinChange {

    public static int coinChange(int[] coins, int amount, int[] m) {
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        if (m[amount - 1] != 0)
            return m[amount - 1];

        int minQnt = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; ++i) {
            int result = coinChange(coins, amount - coins[i], m);
            if (result >= 0 && result < minQnt)
                minQnt = 1 + result;
        }
        m[amount - 1] = (minQnt == Integer.MAX_VALUE) ? -1 : minQnt;
        return m[amount - 1];
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1)
            return 0;
        int result = coinChange(coins, amount, new int[amount]);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 5 };
        System.out.println(coinChange(arr, 11));
    }
}
