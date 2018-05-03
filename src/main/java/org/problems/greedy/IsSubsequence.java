package org.problems.greedy;

//https://leetcode.com/problems/is-subsequence/description/
public class IsSubsequence {

    public static boolean isSubsequence1(String s, String t) {
        int is = 0;
        int it = 0;
        while (is < s.length() && it < t.length()) {
            if (s.charAt(is) == t.charAt(it)) {
                ++is;
            }
            ++it;
        }
        return is == s.length();
    }

    public static boolean isSubsequence(String s, String t) {
        for (int is = 0, it = 0; is < s.length(); ++is, ++it) {
            it = t.indexOf(s.charAt(is), it);
            if (it == -1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("ace", "abcde") == true);
        System.out.println(isSubsequence("aec", "abcde") == false);

    }
}
