package org.problems.greedy;

import java.util.Arrays;

//https://leetcode.com/contest/weekly-contest-96/problems/boats-to-save-people/
public class BoatstoSavePeople {

    public static int binarySearch(int[] people, int lo, int hi, int val) {
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (people[mid] == val) {
                lo = mid;
                break;
            }
            if (people[mid] < val)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        while (lo < people.length - 1 && people[lo + 1] == people[lo])
            ++lo;
        return lo;
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        boolean[] rescued = new boolean[people.length];
        int boats = 0;
        for (int i = people.length - 1; i >= 0; --i) {
            if (rescued[i]) continue;
            rescued[i] = true;
            int second = binarySearch(people, 0, i - 1, limit - people[i]);
            while (second >= 0 && (rescued[second] || people[second] > limit - people[i]))
                --second;
            if (second >= 0 && !rescued[second] && people[second] <= limit - people[i]) {
                rescued[second] = true;
            }
            ++boats;
        }

        return boats;
    }

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{8, 3, 8, 3, 10, 2, 9, 1, 3, 6, 6, 4, 2, 3, 3, 8, 10, 6, 1, 8, 4, 4, 6, 3, 10, 2, 5, 3, 6, 6, 7, 6, 5, 7, 5, 8, 8, 3, 4, 7, 2, 7, 4, 6, 2, 7, 4, 5, 5, 5, 7, 4, 7, 1, 4, 8, 1, 7, 1, 5, 9, 1, 6, 1, 9, 7, 8, 7, 1, 1, 7, 10, 9, 7, 8, 3, 8, 3, 2, 5, 4, 2, 5, 9, 5, 5, 8, 6, 2, 10, 5, 8, 4, 9, 4, 3, 2, 10, 6, 1}, 10));
        System.out.println(numRescueBoats(new int[]{445, 597, 385, 576, 291, 190, 187, 613, 657, 477}, 1000));
        System.out.println(numRescueBoats(new int[]{3, 5, 3, 4}, 5));
        System.out.println(numRescueBoats(new int[]{2, 2, 2, 3, 3}, 6));
        System.out.println(numRescueBoats(new int[]{3, 2, 2, 1}, 3));
    }
}
