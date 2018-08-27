package org.problems.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-uncommon-subsequence-ii/description/
public class LongestUncommonSubsequence2 {

    public static int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> {
            if (b.length() == a.length())
                return a.compareTo(b);
            return Integer.compare(b.length(), a.length());
        });

        Set<String> duplicates = new HashSet<>();
        for (int i = 1; i < strs.length; ++i)
            if (strs[i].equals(strs[i - 1]))
                duplicates.add(strs[i]);

        for (int i = 0; i < strs.length; ++i) {
            if (!duplicates.contains(strs[i])) {
                if (i == 0) return strs[i].length();
                for (int j = 0; j < i; ++j) {
                    if (isSubsequance(strs[j], strs[i]))
                        break;
                    else if (j == i - 1)
                        return strs[i].length();
                }
            }
        }
        return -1;
    }

    private static boolean isSubsequance(String a, String b) {
        int i = 0;
        int j = 0;
        while (j < b.length() && i < a.length()) {
            if (a.charAt(i) == b.charAt(j))
                ++j;
            ++i;
        }
        return j == b.length();
    }

    public static void main(String[] args) {

        System.out.println(findLUSlength(new String[]{"a", "b", "c", "d", "e", "f", "a", "b", "c", "d", "e", "f"}) == -1);
        System.out.println(findLUSlength(new String[]{"aabbcc", "aabbcc", "c"}) == -1);
        System.out.println(findLUSlength(new String[]{"aba", "cdc", "qwer", "qwer", "eae"}) == 3);
    }
}
