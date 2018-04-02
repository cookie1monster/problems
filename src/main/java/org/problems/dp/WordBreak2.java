package org.problems.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/word-break/description/
public class WordBreak2 {

    public static boolean wordBreak(String s, Set<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        int len = s.length();
        for (int i = 0; i <= len - i; i++) {
            if (wordDict.contains(s.substring(0, i)) && wordBreak(s.substring(i, len - i), wordDict))
                return true;
        }
        return false;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return wordBreak(s, wordSet);
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
        System.out.println(wordBreak("abcd", new ArrayList<>(Arrays.asList("a", "abc", "b", "cd"))));
        System.out.println(wordBreak("aaaaaaaa", new ArrayList<>(Arrays.asList("aaaa", "aa", "a"))));
        System.out.println(wordBreak(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                new ArrayList<>(
                        Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
                                "aaaaaaaaaa"))));
    }
}