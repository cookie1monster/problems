package org.problems.array;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/contiguous-array/description/
public class ContiguousArray {

    public static int findMaxLength(int[] nums) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        for (int i = 0; i < nums.length; ++i) {
            count += (nums[i] == 1) ? 1 : -1;
            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{1, 0, 0, 0, 1, 1, 0, 1, 0}));
    }
}
