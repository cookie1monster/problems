package org.problems.array;

//https://leetcode.com/problems/non-decreasing-array/description/
public class NonDecreasingArray {

    public static boolean checkPossibility(int[] nums) {
        boolean toChange = false;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                if (toChange)
                    return false;
                else {
                    toChange = true;
                    int leftMin = (i > 0) ? Math.min(nums[i - 1], nums[i]) : Integer.MIN_VALUE;
                    int rightMin = Math.min(nums[i], nums[i + 1]);
                    if (leftMin > rightMin) {
                        nums[i + 1] = nums[i];
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(checkPossibility(new int[]{3, 3, 2, 2}) == false);
        System.out.println(checkPossibility(new int[]{2, 3, 3, 2, 4}) == true);
        System.out.println(checkPossibility(new int[]{-1, 4, 2, 3}) == true);
        System.out.println(checkPossibility(new int[]{3, 4, 2, 3}) == false);
        System.out.println(checkPossibility(new int[]{4, 2, 3}) == true);
        System.out.println(checkPossibility(new int[]{4, 2, 1}) == false);
    }
}
