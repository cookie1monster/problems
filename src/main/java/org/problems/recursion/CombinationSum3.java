package org.problems.recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum-iii/description/
public class CombinationSum3 {

    private static void combinationSum3(int k, int n, int start, List<Integer> list, List<List<Integer>> lists) {
        if (list.size() == k && n == 0) {
            lists.add(new ArrayList<>(list));
        }
        if (list.size() == k || n <= 0)
            return;

        for (int i = start; i <= 9; ++i) {
            if (n - i >= 0) {
                list.add(i);
                combinationSum3(k, n - i, i + 1, list, lists);
                list.remove(list.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        combinationSum3(k, n, 1, new ArrayList<>(), lists);
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
    }
}
