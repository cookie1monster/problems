package org.problems.dp;

//https://leetcode.com/problems/house-robber/description/
public class HouseRobber {

    // prev1 prev2 cur
    public static int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int prev1 = nums[0];
        int prev2 = Math.max(nums[0], nums[1]);
        int cur = prev2;
        for (int i = 2; i < nums.length; ++i) {
            cur = Math.max(prev1 + nums[i], prev2);
            prev1 = prev2;
            prev2 = cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }
}
