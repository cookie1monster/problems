package org.problems.easy;

import java.util.*;

//https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
public class IntersectionTwoArrays2 {

    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] numsBig = nums1;
        int[] numsSmall = nums2;
        if (nums1.length < nums2.length) {
            numsBig = nums2;
            numsSmall = nums1;
        }

        int resultCount = 0;
        Map<Integer, Integer> frequentMap = new HashMap<>();
        int[] result = new int[numsSmall.length];

        for (int num : numsSmall) {
            frequentMap.put(num, frequentMap.getOrDefault(num, 0) + 1);
        }

        for (int num : numsBig) {
            if (frequentMap.getOrDefault(num, 0) > 0) {
                result[resultCount++] = num;
                frequentMap.put(num, frequentMap.get(num) - 1);
            }
        }
        return Arrays.copyOf(result, resultCount);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1}, new int[]{1, 1})));
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
}
