package org.problems.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
public class CountSmallerNumbersAfterSelf {

    public static int binarySearch(List<Integer> arr, int val, int lo, int hi) {
        if (lo > hi)
            return -1;
        int mid = (lo + hi) / 2;
        if (arr.get(mid) == val) {
            return mid;
        } else if (arr.get(mid) < val) {
            return binarySearch(arr, val, mid + 1, hi);
        } else {
            return binarySearch(arr, val, lo, mid - 1);
        }
    }

    public static List<Integer> countSmaller(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; ++i) {
            list.add(arr[i]);
        }

        List<Integer> result = new ArrayList<>(nums.length);

        for (int i = 0; i < nums.length; ++i) {
            int index = binarySearch(list, nums[i], 0, list.size());
            do {
                --index;
            } while (index >= 0 && nums[i] == list.get(index));
            index++;
            result.add(index);
            list.remove(index);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(countSmaller(new int[] { 5, 2, 6, 1 }));
    }
}
