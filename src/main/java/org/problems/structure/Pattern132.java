package org.problems.structure;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/132-pattern/description/
public class Pattern132 {

    public static boolean find132pattern1(int[] nums) {
        if (nums.length < 3)
            return false;

        int leftVal = nums[0];
        for (int mid = 1; mid < nums.length - 1; ++mid) {
            if (leftVal >= nums[mid])
                leftVal = nums[mid];
            else
                for (int right = mid + 1; right < nums.length; ++right) {
                    if (nums[right] < nums[mid] && nums[right] > leftVal)
                        return true;
                }
        }

        return false;
    }


    public static boolean find132pattern(int[] nums) {
        if (nums.length < 3)
            return false;

        int[] minArr = new int[nums.length];
        minArr[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            minArr[i] = Math.min(minArr[i - 1], nums[i]);
        }

        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] > minArr[i]) {
                while (stack.size() > 0 && nums[i] > stack.peekFirst()) {
                    if (minArr[i] < stack.peekFirst())
                        return true;
                    stack.pollFirst();
                }
                stack.addFirst(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{-1, 3, 2, 0}));
    }

}
