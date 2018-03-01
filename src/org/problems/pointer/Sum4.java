package org.problems.pointer;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/4sum/description/
public class Sum4 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> lists = new HashSet<>();
        Deque<Integer> list = new LinkedList<>();

        for (int j = 0; j < nums.length - 3; ++j) {
            if (j < nums.length - 3 || nums[j] != nums[j + 3]) {
                list.add(nums[j]);
                int sum = target - nums[j];
                for (int i = j + 1; i < nums.length - 2; ++i) {
                    if (i < nums.length - 2 || nums[i] != nums[i + 2]) {
                        sum -= nums[i];
                        list.add(nums[i]);
                        twoSum(nums, lists, list, i, sum);
                        list.pollLast();
                        sum += nums[i];
                    }
                }
                list.pollLast();
            }
        }
        return new LinkedList<>(lists);
    }

    public static void twoSum(int[] nums, Set<List<Integer>> lists, Deque<Integer> list, int i, int sum) {
        int lo = i + 1;
        int hi = nums.length - 1;

        while (lo < hi) {
            if (nums[lo] + nums[hi] == sum) {
                list.add(nums[lo]);
                list.add(nums[hi]);
                lists.add(new LinkedList<>(list));
                list.pollLast();
                list.pollLast();
                while (lo < hi && nums[lo] == nums[lo + 1])
                    lo++;
                while (lo < hi && nums[hi - 1] == nums[hi])
                    hi--;
                lo++;
                hi--;
            } else if (nums[lo] + nums[hi] < sum)
                lo++;
            else
                hi--;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = fourSum(new int[] { -1, 0, -1, 0, -2, 2 }, 0);
        lists.forEach(System.out::println);
        lists = fourSum(new int[] { 0, 0, 0, 0 }, 0);
        lists.forEach(System.out::println);
        lists = fourSum(new int[] { -3, -2, -1, 0, 0, 1, 2, 3 }, 0);
        lists.forEach(System.out::println);
    }
}
