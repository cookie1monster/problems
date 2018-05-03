package org.problems.greedy;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/number-of-matching-subsequences/
public class NumberofMatchingSubsequences {

    private static int isSubsequence(String s, String t) {
        for (int is = 0, it = 0; is < s.length(); ++is, ++it) {
            it = t.indexOf(s.charAt(is), it);
            if (it == -1)
                return 0;
        }
        return 1;
    }

    public static int numMatchingSubseq(String S, String[] words) {
        Map<String, Integer> subsequence = new HashMap<>();
        int result = 0;
        for (String t : words) {
            if (subsequence.keySet().contains(t)) {
                result += subsequence.get(t);
            } else {
                int isSubsequence = isSubsequence(t, S);
                subsequence.put(t, isSubsequence);
                result += isSubsequence;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}) == 3);
    }
}
