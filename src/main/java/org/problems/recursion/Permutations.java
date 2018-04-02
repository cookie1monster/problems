package org.problems.recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/description/
public class Permutations {

    public static void permute(int[] nums, List<Integer> list, List<List<Integer>> permutations) {
        if (list.size() == nums.length)
            permutations.add(new ArrayList<>(list));

        for (int i = 0; i < nums.length; ++i) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                permute(nums, list, permutations);
                list.remove(list.size() - 1);
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permute(nums, new ArrayList<>(), permutations);
        return permutations;
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[] { 1, 2, 3 }));
    }
}
