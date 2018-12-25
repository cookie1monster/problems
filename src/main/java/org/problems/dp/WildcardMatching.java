package org.problems.dp;

//https://leetcode.com/problems/wildcard-matching/description/
public class WildcardMatching {

    public static boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, start = -1;
        while (s < str.length()) {
            if (p < pattern.length() &&
                    (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
                ++p;
                ++s;
            } else if (p < pattern.length() && pattern.charAt(p) == '*') {
                match = s;
                start = p;
                ++p;
            } else if (start != -1) {
                ++match;
                s = match;
                p = start + 1;
            } else
                return false;
        }
        while (p < pattern.length() && pattern.charAt(p) == '*')
            ++p;
        return p >= pattern.length();

    }

    public static void main(String[] args) {
        System.out.println(isMatch("adceb", "*a*b") == true);
        System.out.println(isMatch("acdcb", "a*c?b") == false);
    }
}
