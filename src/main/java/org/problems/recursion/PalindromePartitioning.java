package org.problems.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/palindrome-partitioning/description/
public class PalindromePartitioning {

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < (s.length() / 2); ++i) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static void partition(String s, int added, List<String> partitions, List<List<String>> result) {
        if (added == s.length()) {
            result.add(new ArrayList<>(partitions));
            return;
        }
        for (int i = added; i < s.length(); i++) {
            String substr = s.substring(added, i + 1);
            if (isPalindrome(substr)) {
                partitions.add(substr);
                partition(s, i + 1, partitions, result);
                partitions.remove(partitions.size() - 1);
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.length() < 2) {
            result.add(Collections.singletonList(s));
            return result;
        }
        partition(s, 0, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {

        System.out.println(partition("seeslaveidemonstrateyetartsnomedievalsees"));
        System.out.println(partition("aba"));
        System.out.println(partition("aab"));
        System.out.println(partition("aabb"));
    }
}
