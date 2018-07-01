package org.problems.array;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/largest-rectangle-in-histogram/description/
public class LargestRectangleinHistogram {

    public static int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new LinkedList<>();
        int res = 0;
        for (int num : heights) {
            if (stack.isEmpty() || stack.peekFirst()[0] < num) {
                stack.addFirst(new int[]{num, 1});
            } else if (!stack.isEmpty() && stack.peekFirst()[0] == num) {
                stack.peekFirst()[1]++;
            } else {
                int count = 0;
                while (!stack.isEmpty() && stack.peekFirst()[0] > num) {
                    int[] top = stack.pollFirst();
                    count += top[1];
                    res = Math.max(res, top[0] * count);
                }
                if (stack.isEmpty() || stack.peekFirst()[0] < num) {
                    stack.addFirst(new int[]{num, count + 1});
                } else if (!stack.isEmpty() && stack.peekFirst()[0] == num) {
                    stack.peekFirst()[1] += count + 1;
                }
            }
        }
        while (!stack.isEmpty()) {
            int[] top = stack.pollFirst();
            res = Math.max(res, top[0] * top[1]);
            if (!stack.isEmpty())
                stack.peekFirst()[1] += top[1];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
