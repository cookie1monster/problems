package org.problems.array;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-k-closest-elements/description/
public class FindKClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0;
        int hi = arr.length - k;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == x || hi - lo < 2) {
                lo = mid;
                break;
            }
            if (x < arr[mid])
                hi = mid;
            else
                lo = mid;
        }
        lo = Math.max(0, lo - k);
        while (lo + k < arr.length && x - arr[lo] > arr[lo + k] - x) {
            ++lo;
        }
        List<Integer> res = new ArrayList<>(k);
        for (int i = lo; i < lo + k; ++i)
            res.add(arr[i]);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5));
        System.out.println(findClosestElements(new int[]{1, 1, 2, 3, 3, 3, 4, 6, 8, 8}, 6, 1));
        System.out.println(findClosestElements(new int[]{1, 2, 7, 8}, 4, 3));
    }
}
