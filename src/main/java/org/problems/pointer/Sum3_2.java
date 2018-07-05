package org.problems.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/3sum/description/
public class Sum3_2 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3)
            return lists;
        Arrays.sort(nums);

        for (int i = 2; i < nums.length; ++i) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) continue;
            int lo = 0;
            int hi = i - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum < 0) {
                    ++lo;
                } else if (sum > 0) {
                    --hi;
                } else {
                    lists.add(Arrays.asList(nums[lo], nums[hi], nums[i]));
                    --hi;
                    while (lo < hi && nums[hi] == nums[hi + 1])
                        --hi;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {

        List<List<Integer>> lists1 = threeSum(new int[]{2, -1, -1, -1});
        lists1.forEach(System.out::println);

        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        lists.forEach(System.out::println);
        lists = threeSum(new int[]{0, 0, 0, 0});
        lists.forEach(System.out::println);
        lists = threeSum(new int[]{0, 1, 1});
        lists.forEach(System.out::println);


    }
}
