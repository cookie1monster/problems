package org.problems.easy;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/happy-number/description/
public class HappyNumber {

    public static boolean isHappy(int n) {
        int val = n;
        Set<Integer> set = new HashSet<>();
        while (set.add(val)) {
            int sum = 0;
            while (val > 0) {
                sum += (val % 10) * (val % 10);
                val /= 10;
            }
            val = sum;
        }
        return val == 1;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(82));
    }
}
