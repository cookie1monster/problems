package org.problems.easy;

//https://leetcode.com/problems/groups-of-special-equivalent-strings/description/
public class GroupsSpecialEquivalentStrings {

    public static int numSpecialEquivGroups(String[] A) {
        int[][][] freq = new int[2][A.length][26];
        for (int j = 0; j < A.length; ++j) {
            for (int i = 0; i < A[j].length(); i += 2)
                ++freq[0][j][A[j].charAt(i) - 'a'];

            for (int i = 1; i < A[j].length(); i += 2)
                ++freq[1][j][A[j].charAt(i) - 'a'];
        }
        boolean[] used = new boolean[A.length];
        int groups = 0;
        for (int i = 0; i < A.length; ++i) {
            if (used[i]) continue;
            ++groups;
            for (int j = i + 1; j < A.length; ++j) {
                if (used[j]) continue;
                boolean isUsed = true;
                for (int k = 0; k < 26; ++k) {
                    if (freq[0][i][k] != freq[0][j][k] || freq[1][i][k] != freq[1][j][k]) {
                        isUsed = false;
                        break;
                    }
                }
                used[j] = isUsed;
            }
        }

        return groups;
    }

    public static void main(String[] args) {
        System.out.println(numSpecialEquivGroups(new String[]{}));
        System.out.println(numSpecialEquivGroups(new String[]{"a", "b", "c", "a", "c", "c"}));
        System.out.println(numSpecialEquivGroups(new String[]{"aa", "bb", "ab", "ba"}));
        System.out.println(numSpecialEquivGroups(new String[]{"abc", "acb", "bac", "bca", "cab", "cba"}));
        System.out.println(numSpecialEquivGroups(new String[]{"abcd", "cdab", "adcb", "cbad"}));

    }
}
