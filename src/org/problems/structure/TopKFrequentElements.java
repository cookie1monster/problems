package org.problems.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/top-k-frequent-elements/description/
public class TopKFrequentElements {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        }

        for (Integer value : frequencyMap.keySet()) {
            if (bucket[frequencyMap.get(value)] == null) {
                bucket[frequencyMap.get(value)] = new ArrayList<>();
            }
            bucket[frequencyMap.get(value)].add(value);
        }

        List<Integer> result = new ArrayList<>();
        int i = nums.length;
        while (result.size() < k) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
            --i;
        }
        return result.subList(0, k);
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[] { 5, 3, 1, 1, 1, 3, 73, 1 }, 2));
        System.out.println(topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2));
    }
}
