package org.problems.sort;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/largest-number/description/
public class LargestNumber {

    public static String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new StringComparator());
        StringBuilder result = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; --i) {
            result = result.append(strs[i]);
        }
        if ("0".equals(strs[strs.length - 1])) {
            return "0";
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }));
        System.out.println(largestNumber(new int[] { 824, 8247 }));
        System.out.println(largestNumber(new int[] { 824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247 }));
        System.out.println(largestNumber(new int[] { 0, 0 }));
        System.out.println(largestNumber(new int[] { 12, 121 }));
        System.out.println(largestNumber(new int[] { 3, 30, 34, 5, 9 }));
        System.out.println(largestNumber(new int[] { 128, 12 }));
    }

    static class StringComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return (s1 + s2).compareTo(s2 + s1);
        }
    }
}
