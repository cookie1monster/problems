package org.problems.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

//https://leetcode.com/problems/insert-delete-getrandom-o1/description/
public class InsertDeleteGetRandom {

    public static void main(String[] args) {
        new RandomizedSet();
    }
}

class RandomizedSet {

    Map<Integer, Integer> indexMap;
    List<Integer> nums;
    Random rand = new Random();

    public RandomizedSet() {
        indexMap = new HashMap<>();
        nums = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (indexMap.containsKey(val)) return false;
        indexMap.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) return false;
        int index = indexMap.get(val);
        int lastElement = nums.get(nums.size() - 1);
        nums.set(index, lastElement);
        indexMap.put(lastElement, index);
        nums.remove(nums.size() - 1);
        indexMap.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int index = rand.nextInt(nums.size());
        return nums.get(index);
    }
}
