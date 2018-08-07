package org.problems.structure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/sliding-window-median/
public class SlidingWindowMedian {

    private static void rebalance(PriorityQueue<Integer> lo, PriorityQueue<Integer> hi) {
        if (Math.abs(lo.size() - hi.size()) > 1) {
            if (lo.size() < hi.size())
                lo.add(hi.poll());
            else
                hi.add(lo.poll());
        }
    }

    private static void addNext(PriorityQueue<Integer> lo, PriorityQueue<Integer> hi, int val) {
        if (lo.size() > 0 && val <= lo.peek())
            lo.offer(val);
        else if (hi.size() > 0 && val >= hi.peek())
            hi.offer(val);
        else
            lo.offer(val);
        rebalance(lo, hi);
    }

    private static void removeFirst(PriorityQueue<Integer> lo, PriorityQueue<Integer> hi, int val) {
        if (lo.size() > 0 && val <= lo.peek()) {
            lo.remove(val);
        } else {
            hi.remove(val);
        }
        rebalance(lo, hi);
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] medians = new double[nums.length - k + 1];
        Comparator<Integer> comp = (Integer::compare);
        PriorityQueue<Integer> lo = new PriorityQueue<>(comp.reversed());
        PriorityQueue<Integer> hi = new PriorityQueue<>(comp);

        int end = 0;
        for (; end < k - 1; ++end)
            addNext(lo, hi, nums[end]);

        for (int i = 0; i < medians.length; ++i) {
            addNext(lo, hi, nums[end++]);

            if (lo.size() == hi.size())
                medians[i] = (1. * lo.peek() + hi.peek()) / 2;
            else
                medians[i] = hi.size() > lo.size() ? hi.peek() : lo.peek();

            removeFirst(lo, hi, nums[end - k]);
        }

        return medians;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{-2, -2, 3}, 3)));
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{-2147483648, -2147483648, 2147483647}, 3)));
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{1, 4, 2, 3}, 4)));
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{2147483647, 7, 6, 5, 4, 3, 2, 1, 2147483647}, 2)));
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{2147483647, 1, 2, 3, 4, 5, 6, 7, 2147483647}, 2)));
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{2147483647, 2147483647}, 2)));
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{1, 2, 3, 4, 2, 3, 1, 4, 2}, 3)));
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{1}, 1)));
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
