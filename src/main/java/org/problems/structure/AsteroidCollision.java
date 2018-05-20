package org.problems.structure;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/asteroid-collision/description/
public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for (int val : asteroids) {
            if (val < 0) {
                while (!stack.isEmpty() && stack.peekFirst() > 0) {
                    int peekVal = stack.peekFirst();
                    if (Math.abs(peekVal) <= Math.abs(val))
                        stack.pollFirst();

                    if (Math.abs(peekVal) >= Math.abs(val)) {
                        val = 0;
                        break;
                    }
                }
            }
            if (val != 0)
                stack.addFirst(val);
        }
        int[] res = new int[stack.size()];
        int i = stack.size();
        for (int val : stack)
            res[--i] = val;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{8, -8})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10, 2, -5})));
    }

}
