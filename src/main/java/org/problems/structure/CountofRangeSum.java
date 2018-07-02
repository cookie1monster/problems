package org.problems.structure;

import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/count-of-range-sum/description/
public class CountofRangeSum {

    public static int countRangeSum1(int[] nums, int lower, int upper) {
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            long sum = 0;
            for (int j = i; j < nums.length; ++j) {
                sum += nums[j];
                if (lower <= sum && sum <= upper)
                    ++count;
            }
        }
        return count;
    }

    public static int countRangeSum(int[] nums, int lower, int upper) {
        //lower < sum[i] - sum[j] < upper
        //sum[i] - lower >= sum[j] >= sum[i] - upper
        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(0L, 1);
        int count = 0;
        long sum = 0;
        for (int num : nums) {
            sum += num;
            Map<Long, Integer> subMap = map.subMap(sum - upper, true, sum - lower, true);
            for (long qnt : subMap.values())
                count += qnt;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countRangeSum(new int[]{-2, 5, -1}, -2, 2) == 3);
    }

}
