package org.problems.bits;

import java.util.Arrays;

//https://leetcode.com/problems/single-number-iii/description/
public class SingleNumber3 {

    public static int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums)
            xor = xor ^ num;

        xor &= -xor;
        int[] res = new int[]{0, 0};
        for (int num : nums)
            res[((num & xor) == 0) ? 0 : 1] ^= num;
        return res;
    }

    public static void main(String[] args) {
        int xor = 11;
        System.out.println((xor & (xor - 1)) ^ xor);
        System.out.println(Arrays.toString(singleNumber(new int[]{0, 1, 2, 2})));
        System.out.println(Arrays.toString(singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
