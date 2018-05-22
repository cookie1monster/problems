package org.problems.structure;

import java.util.Arrays;

//https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
public class PartitionKEqualSumSubsets {

    private static boolean canPartitionKSubsets(int[] nums, int[] group, int target, int index) {
        if (index < 0)
            return true;
        int val = nums[index--];
        for (int i = 0; i < group.length; ++i) {
            if (group[i] + val <= target) {
                group[i] += val;
                if (canPartitionKSubsets(nums, group, target, index))
                    return true;
                group[i] -= val;
            }
            if (group[i] == 0)
                break;
        }
        return false;
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % k > 0)
            return false;
        Arrays.sort(nums);
        int target = sum / k;
        if (nums[nums.length - 1] > target)
            return false;

        int index = nums.length - 1;
        while (k >= 0 && nums[index] == target) {
            --index;
            --k;
        }
        int[] group = new int[k];

        return canPartitionKSubsets(nums, group, target, index);
    }

    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }

}
