package org.problems.easy;

import java.util.Arrays;
import java.util.stream.Collectors;

//https://leetcode.com/problems/plus-one/description/
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int[] result = Arrays.copyOf(digits, digits.length);
        for (int i = result.length - 1; i >= 0; --i) {
            if (result[i] != 9) {
                result[i]++;
                return result;
            }
            result[i] = 0;
        }
        result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.stream(plusOne(new int[]{9, 9, 9})).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(plusOne(new int[]{9, 7, 9, 9})).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(plusOne(new int[]{1, 2, 3, 4})).boxed().collect(Collectors.toList()));
    }
}
