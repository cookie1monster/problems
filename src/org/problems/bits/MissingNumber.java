package org.problems.bits;

//https://leetcode.com/problems/missing-number/description/
public class MissingNumber {

    static public int missingNumber(int[] nums) {
        int result = nums.length;
        for(int i=0; i<nums.length; ++i) {
            result += i - nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(8 == missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(2 == missingNumber(new int[]{3,0,1}));
    }
}
