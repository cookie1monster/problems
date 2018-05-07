package org.problems.bits;

//https://leetcode.com/problems/single-number-ii/description/
public class SingleNumber2 {

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int j = 0; j < 32; j++) {
            int sum = 0;
            for (int i = 0; i < nums.length; ++i) {
                sum += nums[i] & 1;
                nums[i] = nums[i] >>> 1;
            }
            sum %= 3;
            if(sum != 0) {
                result |= sum << j;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(singleNumber(new int[]{2, 2, 3, 2}) == 3);
        System.out.println(singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}) == 99);
        System.out.println(singleNumber(new int[]{-2, -2, 1, 1, -3, 1, -3, -3, -4, -2}) == -4);
    }
}
