package org.problems.structure;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; ++i) {
            queue.offer(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
        System.out.println(findKthLargest(new int[] { 5, 3, 1, 1, 1, 3, 73, 1 }, 2));
        System.out.println(findKthLargest(new int[] { 1, 1, 1, 2, 2, 3 }, 2));
    }
}
