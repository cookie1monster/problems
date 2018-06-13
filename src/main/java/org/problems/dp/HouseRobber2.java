package org.problems.dp;

//https://leetcode.com/problems/house-robber-ii/description/
public class HouseRobber2 {

    public static int rob(int[] nums, int start) {
        int prev1 = nums[start];
        int prev2 = Math.max(nums[start], nums[1 + start]);
        int cur = prev2;
        for (int i = 2 + start; i < nums.length; ++i) {
            cur = Math.max(prev1 + nums[i], prev2);
            prev1 = prev2;
            prev2 = cur;
        }
        if (start == 0 && nums.length > 2)
            return Math.min(prev1, cur);
        return cur;
    }

    public static int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return rob(nums, 0);

        return Math.max(rob(nums, 0), rob(nums, 1));
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3}) == 3);
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}) == 11);
        System.out.println(rob(new int[]{1, 2, 1, 1}) == 3);
        System.out.println(rob(new int[]{2, 3, 2}) == 3);
        System.out.println(rob(new int[]{1, 2, 3, 1}) == 4);
    }
}
