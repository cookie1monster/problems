package org.problems.string;

//https://leetcode.com/problems/repeated-substring-pattern/description/
public class RepeatedSubstringPattern {

    public static boolean repeatedSubstringPattern(String s) {
        if (s.length() < 2)
            return false;

        for (int i = 2; i <= s.length() / 2; ++i) {
            if (s.length() % i == 0) {
                int shift = s.length() / i;
                String pattern = s.substring(0, shift);
                int j = shift;
                for (; j < s.length(); j += shift) {
                    if (s.indexOf(pattern, j) != j)
                        break;
                }
                if (j >= s.length())
                    return true;
            }
        }
        int k = 0;
        while (k < s.length() && s.indexOf(s.charAt(0), k) == k)
            ++k;
        return k >= s.length();
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("ab") == false);
        System.out.println(repeatedSubstringPattern("aaaaaaaaaaaaa") == true);
        System.out.println(repeatedSubstringPattern("bbb") == true);
        System.out.println(repeatedSubstringPattern("bb") == true);
        System.out.println(repeatedSubstringPattern("") == false);
        System.out.println(repeatedSubstringPattern("a") == false);
        System.out.println(repeatedSubstringPattern("abab") == true);
        System.out.println(repeatedSubstringPattern("aba") == false);
        System.out.println(repeatedSubstringPattern("abcabcabcabc") == true);
    }
}
