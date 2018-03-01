package org.problems.pointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/3sum/description/
public class Sum3 {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int sum = 0 - nums[i];
                int lo = i + 1;
                int hi = nums.length - 1;
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        lists.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
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
        }
        return lists;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
        lists.forEach(System.out::println);
        lists = threeSum(new int[] { 0, 0, 0 });
        lists.forEach(System.out::println);
        lists = threeSum(new int[] { 0, 1, 1 });
        lists.forEach(System.out::println);
    }
}
