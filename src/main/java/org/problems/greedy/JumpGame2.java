package org.problems.greedy;

//https://leetcode.com/problems/jump-game/description/
public class JumpGame2 {

    public static int canJump(int[] nums) {
        int count = 0;
        int next = 0;
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == next) {
                next = max;
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
