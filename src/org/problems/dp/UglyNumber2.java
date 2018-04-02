package org.problems.dp;

//https://leetcode.com/problems/ugly-number-ii/description/
public class UglyNumber2 {

    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        for (int i = 1; i < dp.length; i++) {
            int val2 = dp[idx2] * 2;
            int val3 = dp[idx3] * 3;
            int val5 = dp[idx5] * 5;
            dp[i] = Math.min(val2, Math.min(val3, val5));
            idx2 = (dp[i] == val2) ? idx2 + 1 : idx2;
            idx3 = (dp[i] == val3) ? idx3 + 1 : idx3;
            idx5 = (dp[i] == val5) ? idx5 + 1 : idx5;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1690));
        System.out.println(nthUglyNumber(1500));
        System.out.println(nthUglyNumber(15));
        System.out.println(nthUglyNumber(57));
        System.out.println(nthUglyNumber(1));
    }
}
