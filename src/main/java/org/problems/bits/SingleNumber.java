package org.problems.bits;

//https://leetcode.com/problems/single-number/description/
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] { 1, 2, 8, 3, 2, 1, 8 }));
    }
}
