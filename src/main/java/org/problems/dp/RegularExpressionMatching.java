package org.problems.dp;

//https://leetcode.com/problems/regular-expression-matching/description/
public class RegularExpressionMatching {

    private static boolean isMatch(String s, String p, Boolean[][] dp) {
        if (dp[s.length()][p.length()] != null)
            return dp[s.length()][p.length()];
        int ip = p.length() - 1;
        int is = s.length() - 1;
        while (ip >= 0 && is >= -1) {
            if (is >= 0 && (p.charAt(ip) == '.' || p.charAt(ip) == s.charAt(is))) {
                --ip;
                --is;
            } else if (p.charAt(ip) == '*') {
                --ip;
                if (ip >= 0 && p.charAt(ip) == '.') {
                    --ip;
                    while (is >= -1) {
                        boolean matching = isMatch(s.substring(0, is + 1), p.substring(0, ip + 1), dp);
                        if (matching)
                            return true;
                        dp[is + 1][ip + 1] = false;
                        --is;
                    }
                } else if (ip >= 0) {
                    boolean matching = isMatch(s.substring(0, is + 1), p.substring(0, ip), dp);
                    if (matching)
                        return true;
                    dp[is + 1][ip] = false;
                    char repChar = p.charAt(ip);
                    while (is >= 0 && s.charAt(is) == repChar) {
                        matching = isMatch(s.substring(0, is + 1), p.substring(0, ip + 1), dp);
                        if (matching)
                            return true;
                        dp[is + 1][ip + 1] = false;
                        --is;
                    }
                }
            } else {
                dp[s.length()][p.length()] = false;
                return false;
            }
        }
        dp[s.length()][p.length()] = (ip == -1 && is == -1);
        return dp[s.length()][p.length()];
    }

    public static boolean isMatch(String s, String p) {
        return isMatch(s, p, new Boolean[s.length() + 1][p.length() + 1]);
    }

    public static void main(String[] args) {
        System.out.println(isMatch("mississippi", "mis*is*p*.") == false);
        System.out.println(isMatch("aab", "c*a*b") == true);
        System.out.println(isMatch("ab", ".*") == true);
        System.out.println(isMatch("abcgkfsm", "ab.*c.*k.s.") == true);
        System.out.println(isMatch("aa", "a") == false);
        System.out.println(isMatch("aa", "a*") == true);
    }
}
