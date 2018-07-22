package org.problems.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/majority-element-ii/description/
public class MajorityElement2 {

    private static int majorityElement(int[] nums, int from, int to) {
        int count = 0;
        int candidate = 0;
        for (int i = from; i < to; ++i) {
            if (count == 0)
                candidate = nums[i];
            count += (candidate == nums[i]) ? 1 : -1;
        }
        return candidate;
    }

    public static List<Integer> majorityElement(int[] nums) {
        double oneThirdLen = 1. * nums.length / 3;
        int candidate1 = majorityElement(nums, 0, (nums.length + 1) / 3);
        int offset = (nums.length % 3 > 0) ? nums.length % 3 - 1 : 0;
        int candidate2 = majorityElement(nums, (nums.length + 1) / 3, 2 * nums.length / 3 + offset);
        int candidate3 = majorityElement(nums, 2 * nums.length / 3 + offset, nums.length);

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int num : nums) {
            count1 += (num == candidate1) ? 1 : 0;
            count2 += (num == candidate2) ? 1 : 0;
            count3 += (num == candidate3) ? 1 : 0;
        }
        Set<Integer> res = new HashSet<>();
        if (count1 > oneThirdLen)
            res.add(candidate1);
        if (count2 > oneThirdLen)
            res.add(candidate2);
        if (count3 > oneThirdLen)
            res.add(candidate3);

        if (res.size() == 1) {
            int count = 0;
            int candidate = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] == res.iterator().next()) continue;
                if (count == 0)
                    candidate = nums[i];
                count += (candidate == nums[i]) ? 1 : -1;
            }
            count = 0;
            for (int num : nums)
                count += (num == candidate) ? 1 : 0;

            if (count > oneThirdLen)
                res.add(candidate);
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{8, 9, 8, 9, 8}));
        System.out.println(majorityElement(new int[]{1, 2}));
        System.out.println(majorityElement(new int[]{5, 3, 4, 5}));
        System.out.println(majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));
        System.out.println(majorityElement(new int[]{1, 2, 3, 1, 1, 2, 3, 2}));
    }
}
