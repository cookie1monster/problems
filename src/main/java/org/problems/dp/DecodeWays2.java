package org.problems.dp;

//https://leetcode.com/problems/decode-ways-ii/description/
public class DecodeWays2 {

    public static int numDecodings(String s) {
        long M = 1000000007;
        char[] ch = s.toCharArray();
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = ch[0] == '*' ? 9L : ch[0] == '0' ? 0L : 1L;
        for (int i = 1; i < s.length(); ++i) {
            if (ch[i] == '*') {
                dp[i + 1] = dp[i] * 9L;
                if (ch[i - 1] == '*')
                    dp[i + 1] += dp[i - 1] * 15L;
                else if (ch[i - 1] == '1')
                    dp[i + 1] += dp[i - 1] * 9L;
                else if (ch[i - 1] == '2')
                    dp[i + 1] += dp[i - 1] * 6L;
            } else {
                dp[i + 1] = ch[i] != '0' ? dp[i] : 0;
                if (ch[i - 1] == '1' || (ch[i - 1] == '2' && ch[i] < '7'))
                    dp[i + 1] = dp[i + 1] + dp[i - 1];
                else if (ch[i - 1] == '*')
                    dp[i + 1] = dp[i + 1] + dp[i - 1] * (ch[i] < '7' ? 2L : 1L);
            }
            if (dp[i + 1] >= M)
                dp[i + 1] %= M;
        }
        return (int) dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("1*72") == 19);
        System.out.println(numDecodings("1*72*") == 285);
        System.out.println(numDecodings("0") == 0);
        System.out.println(numDecodings("*1*1*0") == 404);
        System.out.println(numDecodings("*1*1*") == 3438);
        System.out.println(numDecodings("*1*1") == 202);
        System.out.println(numDecodings("*1*") == 180);
        System.out.println(numDecodings("1212") == 5);
        System.out.println(numDecodings("12121") == 8);
        System.out.println(numDecodings("1*") == 18);
    }
}
