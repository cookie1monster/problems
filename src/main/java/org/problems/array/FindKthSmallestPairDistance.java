package org.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/
public class FindKthSmallestPairDistance {

    static class Node {
        public int val;
        public int qnt;

        public Node(int val, int qnt) {
            this.qnt = qnt;
            this.val = val;
        }
    }

    public static int smallestDistancePair1(int[] nums, int k) {
        Arrays.sort(nums);
        List<Node> arr = new ArrayList<>();
        arr.add(new Node(nums[0], 1));
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] != nums[i]) {
                arr.add(new Node(nums[i], 1));
            } else {
                arr.get(arr.size() - 1).qnt++;
            }
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < arr.size(); ++i) {
            if (arr.get(i).qnt > 1) {
                int val = 0;
                freq.put(val, freq.getOrDefault(val, 0) + arr.get(i).qnt * (arr.get(i).qnt - 1) / 2);
            }
            for (int j = i + 1; j < arr.size(); ++j) {
                int val = Math.abs(arr.get(i).val - arr.get(j).val);
                freq.put(val, freq.getOrDefault(val, 0) + arr.get(i).qnt * arr.get(j).qnt);
            }
        }

        Comparator<Integer> comp = Comparator.comparingInt(v -> (v));
        PriorityQueue<Integer> queue = new PriorityQueue<>(comp);
        queue.addAll(freq.keySet());

        int h = 0;
        while (h + freq.get(queue.peek()) < k)
            h += freq.get(queue.poll());
        return queue.poll();
    }

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            int count = 0, left = 0;
            for (int right = 0; right < nums.length; ++right) {
                while (nums[right] - nums[left] > mi) left++;
                count += right - left;
            }
            if (count >= k) hi = mi;
            else lo = mi + 1;
        }
        return lo;
    }


    public static void main(String[] args) {
        System.out.println(smallestDistancePair(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 13));
        System.out.println(smallestDistancePair(new int[]{1, 3, 1}, 1));
        System.out.println(smallestDistancePair(new int[]{62, 100, 4}, 2));
        System.out.println(smallestDistancePair(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 12));
    }
}
