package org.problems.structure;

//https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/
public class SplitArrayintoConsecutiveSubsequences2 {

    public static boolean isPossible(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        int pre1 = 0;
        int pre2 = 0;
        int pre3 = 0;

        int i = 0;
        int prev = 0;
        while (i < nums.length) {
            int cur = nums[i];
            int count = i;
            while (i < nums.length && nums[i] == cur)
                i++;
            count = i - count;

            if (cur == prev + 1) {
                if (count < pre1 + pre2) return false;
                count1 = Math.max(0, count - (pre1 + pre2 + pre3));
                count2 = pre1;
                count3 = pre2 + Math.min(pre3, count - (pre1 + pre2));
            } else {
                if (pre1 != 0 || pre2 != 0) return false;
                count1 = count;
                count2 = 0;
                count3 = 0;
            }
            pre1 = count1;
            pre2 = count2;
            pre3 = count3;
            prev = cur;
        }
        return pre1 == 0 && pre2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPossible(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(isPossible(new int[]{1, 2, 3, 3, 4, 5}));
        System.out.println(isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5}));
        System.out.println(isPossible(new int[]{1, 2, 3, 4, 4, 5}));
    }
}
