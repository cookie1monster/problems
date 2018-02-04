package org.problems.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/word-break/description/
public class WordBreak {

    static int longestWord(List<String> wordDict){
        int len = 0;
        for(String str: wordDict){
            len = Math.max(len, str.length());
        }
        return len;
    }

    static boolean wordBreak(String s, List<String> wordDict) {
        int longetsWord = longestWord(wordDict);
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] isWordBreak = new boolean[s.length() + 1];
        isWordBreak[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = Math.max(0, i - longetsWord); j < i; j++){
                if(isWordBreak[j] && wordSet.contains(s.substring(j, i))) {
                    isWordBreak[i] = true;
                    break;
                }
            }
        }
        return isWordBreak[s.length()];
    }

    public static void main(String[] args) {

        System.out.println(wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet","code"))));
        System.out.println(wordBreak("abcd", new ArrayList<>(Arrays.asList("a","abc","b","cd"))));
        System.out.println(wordBreak("aaaaaaaa", new ArrayList<>(Arrays.asList("aaaa","aa","a"))));
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", new ArrayList<>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"))));

    }
}