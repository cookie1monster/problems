package org.problems.structure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/smallest-range/description/
public class SmallestRange {

    public static int[] smallestRange(List<List<Integer>> nums) {
        int lo = Integer.MAX_VALUE;
        int hi = Integer.MIN_VALUE;
        int k = nums.size();
        for (int i = 0; i < k; ++i) {
            lo = Math.min(lo, nums.get(i).get(0));
            hi = Math.max(hi, nums.get(i).get(nums.get(i).size() - 1));
        }
        int offset = 0 - lo;
        Set<Integer>[] range = new Set[hi - lo + 1];

        for (int i = 0; i < k; ++i) {
            List<Integer> level = nums.get(i);
            for (int j = 0; j < level.size(); ++j) {
                if (range[level.get(j) + offset] == null) {
                    range[level.get(j) + offset] = new HashSet<>();
                }
                range[level.get(j) + offset].add(i);
            }
        }

        int[] result = new int[2];
        result[1] = Integer.MAX_VALUE;
        int size = hi - lo;
        lo = 0;
        hi = lo;
        Set<Integer> levels = new HashSet<>();
        while (hi <= size) {
            while (hi <= size && levels.size() != k) {
                if (range[hi] != null)
                    levels.addAll(range[hi]);
                ++hi;
            }
            Set<Integer> tmp = new HashSet<>();
            lo = hi - 1;
            while (lo >= 0 && tmp.size() != k) {
                if (range[lo] != null)
                    tmp.addAll(range[lo]);
                --lo;
            }

            if (hi - lo - 2 < result[1] - result[0]) {
                result[0] = lo + 1;
                result[1] = hi - 1;
            }
            if (range[++lo] != null)
                levels.removeAll(range[lo]);
            ++lo;
            while (lo < size && range[lo] == null)
                ++lo;
        }
        result[0] -= offset;
        result[1] -= offset;
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = Arrays.asList(Arrays.asList(10, 10), Arrays.asList(11, 11));
        System.out.println(Arrays.toString(smallestRange(nums)));

        nums = Arrays.asList(Arrays.asList(4, 10, 15, 24, 26), Arrays.asList(0, 9, 12, 20), Arrays.asList(5, 18, 22, 30));
        System.out.println(Arrays.toString(smallestRange(nums)));
    }
}
