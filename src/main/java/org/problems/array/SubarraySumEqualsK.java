package org.problems.array;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/description/
public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
        int result = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            result += dp.getOrDefault(sum - k, 0);
            dp.put(sum, dp.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{100, 1, 2, 3, 4}, 6) == 1);
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2) == 2);
    }
}
