package org.problems.structure;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/first-missing-positive/description/
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        int i = 1;
        while (set.contains(i)) {
            ++i;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] { 3, 4, -1, 1 }));
        System.out.println(firstMissingPositive(new int[] { 5, 3, 1, 1, 1, 3, 73, 1 }));
        System.out.println(firstMissingPositive(new int[] { 1, 1, 1, 2, 2, 3 }));
    }
}
