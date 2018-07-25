package org.problems.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/subsets-ii/description/
public class Subsets2 {

    private static void subsets(int[] nums, List<Integer> list, List<List<Integer>> subsets, int start) {
        subsets.add(new ArrayList<>(list));

        Set<Integer> visited = new HashSet<>();
        for (int i = start; i < nums.length; ++i) {
            if (visited.contains(nums[i])) continue;
            visited.add(nums[i]);
            list.add(nums[i]);
            subsets(nums, list, subsets, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets(nums, new ArrayList<>(), subsets, 0);
        return subsets;
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{4, 4, 4, 1, 4}));
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }
}
