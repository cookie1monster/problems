package org.problems.easy;

//https://leetcode.com/problems/jump-game/description/
public class JumpGame {

    public static boolean canJump(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (index < i) {
                return false;
            }
            index = Math.max(index, nums[i] + i);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{0, 1}) == false);
        System.out.println(canJump(new int[]{1, 1, 0, 1}) == false);
        System.out.println(canJump(new int[]{0}) == true);
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}) == false);
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}) == true);
    }
}
