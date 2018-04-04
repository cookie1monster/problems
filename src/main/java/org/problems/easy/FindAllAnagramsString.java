package org.problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
public class FindAllAnagramsString {
    private static final int CHAR_SHIFT = 97;

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length())
            return result;
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            pCount[p.charAt(i) - CHAR_SHIFT]++;
            sCount[s.charAt(i) - CHAR_SHIFT]++;
        }
        sCount[s.charAt(p.length() - 1) - CHAR_SHIFT]--;
        for (int i = p.length() - 1; i < s.length(); ++i) {
            sCount[s.charAt(i) - CHAR_SHIFT]++;
            if (Arrays.equals(sCount, pCount)) {
                result.add(i - (p.length() - 1));
            }
            sCount[s.charAt(i - (p.length() - 1)) - CHAR_SHIFT]--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
