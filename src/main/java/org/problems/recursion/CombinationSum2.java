package org.problems.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/description/
public class CombinationSum2 {

    private static void combinationSum2(int[] candidates, int start, int target, List<List<Integer>> lists, List<Integer> list) {
        if (start > candidates.length || target < 0)
            return;
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            list.add(candidates[i]);
            combinationSum2(candidates, i + 1, target - candidates[i], lists, list);
            list.remove(list.size() - 1);
            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1])
                ++i;
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        combinationSum2(candidates, 0, target, lists, new ArrayList<>());
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(combinationSum2(new int[]{2, 5, 2, 1, 2, 2, 1}, 5));
    }
}
