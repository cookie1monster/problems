package org.problems.string;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-and-replace-pattern/description/
public class FindReplacePattern {

    public static boolean isMatching(String s, String t) {
        int[] replaceS = new int[256];
        int[] replaceT = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            int chS = replaceS[s.charAt(i)];
            int chT = replaceT[t.charAt(i)];
            if (chS != 0 && chT != 0 && (s.charAt(i) != chT || t.charAt(i) != chS))
                return false;

            if (chS == 0 && chT != 0 && s.charAt(i) != chT)
                return false;

            if (chS != 0 && chT == 0 && t.charAt(i) != chS)
                return false;

            if (chS == 0)
                replaceS[s.charAt(i)] = t.charAt(i);
            if (chT == 0)
                replaceT[t.charAt(i)] = s.charAt(i);
        }
        return true;
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();

        for (String word:words) {
            if (isMatching(pattern, word))
                res.add(word);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.print(findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "abb"));
    }
}
