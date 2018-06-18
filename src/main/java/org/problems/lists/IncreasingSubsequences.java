package org.problems.lists;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/increasing-subsequences/description/
public class IncreasingSubsequences {

    private static void findSubsequences(int[] nums, int start, List<Integer> list, List<List<Integer>> lists) {
        if (list.size() > 1)
            lists.add(new ArrayList<>(list));

        // nums between -100 : 100
        boolean[] used = new boolean[201];
        for (int i = start; i < nums.length; ++i) {
            if (!used[nums[i] + 100] && (list.isEmpty() || list.get(list.size() - 1) <= nums[i])) {
                used[nums[i] + 100] = true;
                list.add(nums[i]);
                findSubsequences(nums, i + 1, list, lists);
                list.remove(list.size() - 1);
            }
        }
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        findSubsequences(nums, 0, new ArrayList<>(), lists);
        return lists;
    }

    public static void main(String[] args) {

        System.out.println(findSubsequences(new int[]{4, 6, 7, 7}));
    }
}
