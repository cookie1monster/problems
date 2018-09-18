package org.problems.structure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/sum-of-subarray-minimums/description/
public class LongestWordinDictionary {

    public static String longestWord(String[] words) {
        Arrays.sort(words);

        Set<String> set = new HashSet<>();
        set.add("");
        String ans = "";
        for (String word : words) {
            if (set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                if (word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans) < 0))
                    ans = word;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "z", "apple"}));
    }
}
