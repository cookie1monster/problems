package org.problems.recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/description/
public class Subsets {

    public static void subsets(int[] nums, List<Integer> list, List<List<Integer>> subsets, int start) {
        for (int i = start; i < nums.length; ++i) {
            list.add(nums[i]);
            subsets.add(new ArrayList<>(list));
            subsets(nums, list, subsets, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        subsets(nums, new ArrayList<>(), subsets, 0);
        return subsets;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[] { 1, 2, 3 }));
    }
}
