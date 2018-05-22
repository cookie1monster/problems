package org.problems.structure;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/next-greater-element-ii/
public class NextGreaterElement2 {

    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        if (nums.length < 1)
            return res;
        int max = Integer.MIN_VALUE;
        for (int num : nums)
            max = Math.max(max, num);
        int qnt = 0;
        int iNums = 0;
        boolean toAdd = true;
        Deque<Integer> stack = new LinkedList<>();
        do {
            while (stack.size() > 0 && nums[stack.peekFirst()] < nums[iNums]) {
                res[stack.pollFirst()] = nums[iNums];
                ++qnt;
            }
            if (toAdd) {
                if (nums[iNums] == max) {
                    res[iNums] = -1;
                    ++qnt;
                } else
                    stack.addFirst(iNums);
            }
            ++iNums;
            if (iNums == nums.length) {
                iNums = 0;
                toAdd = false;
            }

        } while (qnt < nums.length);

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{2, 1})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{3, 5, 7, 4, 8, 1})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3, 2, 1})));
    }

}
