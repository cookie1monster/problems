package org.problems.structure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

//https://leetcode.com/problems/sliding-window-maximum/description/
public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        TreeSet<Integer> tree = new TreeSet<>();
        Map<Integer, Integer> freq = new HashMap<>();
        int index = 0;

        for (int i = 0; i < k - 1; ++i) {
            tree.add(nums[i]);
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = k - 1; i < nums.length; ++i) {
            tree.add(nums[i]);
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

            ans[index++] = tree.last();
            int firstIndex = i - k + 1;
            int existingFreq = freq.get(nums[firstIndex]);
            freq.put(nums[firstIndex], existingFreq - 1);
            if (existingFreq == 1)
                tree.remove(nums[firstIndex]);

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
