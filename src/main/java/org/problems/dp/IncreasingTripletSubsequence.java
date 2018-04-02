package org.problems.dp;

//https://leetcode.com/problems/increasing-triplet-subsequence/description/
public class IncreasingTripletSubsequence {

    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= first)
                first = nums[i];
            else if (nums[i] <= second)
                second = nums[i];
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[] { 1, 5, 2, 3 }));
        System.out.println(increasingTriplet(new int[] { 4, 5, 1, 6 }));
        System.out.println(increasingTriplet(new int[] { 1, 2, 3, 4, 5 }));
        System.out.println(increasingTriplet(new int[] { 5, 4, 3, 2, 1 }));
    }
}
