package org.problems.dp;

//https://leetcode.com/problems/decode-ways/description/
public class DecodeWays {

    public static int numDecodings(String s) {
        if (s.length() == 0)
            return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) > '0' && s.charAt(i) <= '9') {
                dp[i + 1] = dp[i];
            }
            if (i > 0 && Integer.valueOf(s.substring(i - 1, i + 1)) > 9
                    && Integer.valueOf(s.substring(i - 1, i + 1)) < 27) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("10"));
        System.out.println(numDecodings("897"));
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("122"));
        System.out.println(numDecodings("2212"));
        System.out.println(numDecodings("12212"));
    }
}
