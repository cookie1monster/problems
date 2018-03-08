package org.problems.search;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-consecutive-sequence/description/
public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        while (set.size() != 0) {
            int val = set.iterator().next();
            int localMax = 1;
            int right = val;
            while (set.contains(++right)) {
                set.remove(right);
                localMax++;
            }
            int left = val;
            while (set.contains(--left)) {
                set.remove(left);
                localMax++;
            }
            set.remove(val);
            result = Math.max(result, localMax);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(arr));
    }
}
