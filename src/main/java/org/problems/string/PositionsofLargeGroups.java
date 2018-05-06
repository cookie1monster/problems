package org.problems.string;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/contest/weekly-contest-83/problems/positions-of-large-groups/
public class PositionsofLargeGroups {

    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        if (S.length() < 3)
            return result;
        int i = 0;
        for (; i < S.length(); ++i) {
            int j = i;
            while (j < S.length() && S.charAt(i) == S.charAt(j))
                ++j;

            if (j - i >= 3) {
                List<Integer> idx = new ArrayList<>();
                idx.add(i);
                idx.add(j - 1);
                result.add(idx);
                i = j-1;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(largeGroupPositions("bbb"));
        System.out.println(largeGroupPositions("abbxxxxzzy"));
        System.out.println(largeGroupPositions("abc"));
        System.out.println(largeGroupPositions("abcdddeeeeaabbbcd"));
    }
}
