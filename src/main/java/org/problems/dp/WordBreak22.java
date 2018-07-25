package org.problems.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/word-break-ii/description/
public class WordBreak22 {

    private static int longestWord(Set<String> wordDict) {
        int len = 0;
        for (String str : wordDict) {
            len = Math.max(len, str.length());
        }
        return len;
    }

    private static boolean[] isWordBreak(String s, Set<String> wordSet, int longetsWord) {
        boolean[] isWordBreak = new boolean[s.length() + 1];
        isWordBreak[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = Math.max(0, i - longetsWord); j < i; j++) {
                if (isWordBreak[j] && wordSet.contains(s.substring(j, i))) {
                    isWordBreak[i] = true;
                    break;
                }
            }
        }
        return isWordBreak;
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int longetsWord = longestWord(wordSet);
        boolean[] isWordBreak = isWordBreak(s, wordSet, longetsWord);
        if (!isWordBreak[s.length()]) {
            return new ArrayList<>();
        }

        List<String>[] wordBreakList = new List[s.length() + 1];
        wordBreakList[0] = new ArrayList<>();
        for (int i = 1; i <= s.length(); ++i) {
            if (!isWordBreak[i]) continue;
            for (int j = Math.max(0, i - longetsWord); j < i; ++j) {
                if (wordBreakList[j] != null && wordSet.contains(s.substring(j, i))) {
                    if (wordBreakList[i] == null)
                        wordBreakList[i] = new ArrayList<>();

                    if (wordBreakList[j].size() == 0)
                        wordBreakList[i].add(s.substring(j, i));
                    else
                        for (String str : wordBreakList[j])
                            wordBreakList[i].add(str + " " + s.substring(j, i));

                }
            }
        }
        return wordBreakList[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                new ArrayList<>(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"))));
        System.out.println(wordBreak("pineapplepenapple", new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"))));
        System.out.println(wordBreak("catsanddog", new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
        System.out.println(wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));

        System.out.println(wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
        System.out.println(wordBreak("abcd", new ArrayList<>(Arrays.asList("a", "abc", "b", "cd"))));
        System.out.println(wordBreak("aaaaaaaa", new ArrayList<>(Arrays.asList("aaaa", "aa", "a"))));
    }
}