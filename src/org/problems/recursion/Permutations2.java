package org.problems.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/permutations-ii/description/
public class Permutations2 {

    static public void permute(int[] nums, List<Integer> list, List<List<Integer>> permutations, boolean[] used) {
        if (list.size() == nums.length)
            permutations.add(new ArrayList<>(list));

        for (int i=0; i<nums.length; ++i) {
            if (used[i] || (i > 0 && nums[i-1] == nums[i] && !used[i-1])) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            permute(nums, list, permutations, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    static public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        Arrays.sort(nums);
        permute(nums, new ArrayList<>(), permutations, new boolean[nums.length]);
        return permutations;
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{3,3,0,3}));
        System.out.println(permuteUnique(new int[]{1,1,2}));
    }
}
