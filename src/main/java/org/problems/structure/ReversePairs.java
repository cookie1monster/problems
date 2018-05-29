package org.problems.structure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/reverse-pairs/description/
public class ReversePairs {

    private static void createBinaryTree(int[] arr, Integer[] bTree, int lo, int hi, int index) {
        if (lo > hi)
            return;
        int mid = (lo + hi) >> 1;
        bTree[index] = arr[mid];
        createBinaryTree(arr, bTree, lo, mid - 1, (index << 1) + 1);
        createBinaryTree(arr, bTree, mid + 1, hi, (index << 1) + 2);
    }

    private static Integer[] createBinaryTree(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        int[] arr = new int[set.size()];
        int j = 0;
        for (int val : set)
            arr[j++] = val;

        Arrays.sort(arr);

        int bTreeLen = (int) Math.pow(2, Math.round(Math.log(arr.length) / Math.log(2)) + 1);
        Integer[] bTree = new Integer[bTreeLen];
        createBinaryTree(arr, bTree, 0, arr.length - 1, 0);
        return bTree;
    }

    //i < j and nums[i] > 2*nums[j].
    public static int reversePairs(int[] nums) {
        Integer[] bTree = createBinaryTree(nums);
        int[] freq = new int[bTree.length];
        int[] eq = new int[bTree.length];
        int res = 0;
        for (int i = nums.length - 1; i >= 0; --i) {

            int index = 0;
            while (index < bTree.length && bTree[index] != null) {
                int val = (nums[i] + 1) >> 1;
                if (bTree[index] > val) {
                    index = (index << 1) + 1;
                } else if (bTree[index] < val) {
                    res += freq[index] + eq[index];
                    index = (index << 1) + 2;
                } else {
                    res += freq[index];
                    break;
                }
            }

            index = 0;
            while (index < bTree.length && bTree[index] != null) {
                if (bTree[index] > nums[i]) {
                    freq[index]++;
                    index = (index << 1) + 1;
                } else if (bTree[index] < nums[i]) {
                    index = (index << 1) + 2;
                } else {
                    eq[index]++;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{2147483647, 2147483647, -2147483647, -2147483647, -2147483647, 2147483647}) == 9);
        System.out.println(reversePairs(new int[]{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647}) == 0);
        System.out.println(reversePairs(new int[]{8, 7, 6, 5, 4, 3, 2, 1}) == 12);

        System.out.println(reversePairs(new int[]{2, 4, 3, 5, 1}) == 3);
        System.out.println(reversePairs(new int[]{1, 3, 2, 3, 1}) == 2);

        System.out.println(reversePairs(new int[]{1, 2, 3, 4, 5}) == 0);
    }

}
