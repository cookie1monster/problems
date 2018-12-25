package org.problems.structure;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-ii/
public class NextGreaterElement2 {

    public static int[] nextGreaterElements1(int[] nums) {
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

    public static int[] nextGreaterElements(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int num : nums)
            max = Math.max(max, num);

        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int[] ans = new int[nums.length];

        while (i < nums.length && max == nums[i]) {
            ans[i++] = -1;
        }

        if (i >= nums.length)
            return ans;

        int count = i;
        stack.push(i++);

        while (!stack.empty() || count < nums.length) {
            if (i >= nums.length)
                i = 0;
            if (stack.empty()) {
                while (i < nums.length && max == nums[i]) {
                    ans[i++] = -1;
                    count++;
                }
                if (i < nums.length)
                   stack.push(i++);
            } else {
                while (!stack.empty() && nums[i] > nums[stack.peek()]) {
                    ans[stack.pop()] = nums[i];
                    count++;
                }
                if (nums[i] == max) {
                    ans[i++] = -1;
                    count++;
                } else
                    stack.push(i++);
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 2, 2, 2, 2})));
//        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
//        System.out.println(Arrays.toString(nextGreaterElements(new int[]{2, 1})));
//        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1})));
//        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2})));
//        System.out.println(Arrays.toString(nextGreaterElements(new int[]{3, 5, 7, 4, 8, 1})));
//        System.out.println(Arrays.toString(nextGreaterElements(new int[]{3, 1, 2, 4})));
//        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3, 2, 1})));
    }

}
