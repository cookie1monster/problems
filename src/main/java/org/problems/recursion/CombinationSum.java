package org.problems.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum/description/
public class CombinationSum {
    private static void combinationSum(int[] candidates, int index, int target, List<List<Integer>> lists, List<Integer> list) {
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        } else if (target < 0)
            return;

        for (int i = index; i < candidates.length; ++i) {
            list.add(candidates[i]);
            combinationSum(candidates, i, target - candidates[i], lists, list);
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (candidates.length < 1 || target < 0)
            return lists;
        Arrays.sort(candidates);
        combinationSum(candidates, 0, target, lists, new ArrayList<>());
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
