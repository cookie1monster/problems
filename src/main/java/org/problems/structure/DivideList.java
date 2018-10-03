package org.problems.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DivideList {

    public static List<List<Integer>> foundGroups(int[] arr) {
        List<List<Integer>> groups = new ArrayList<>();

        int[][] idx = new int[arr.length][2];
        for (int i = 0; i < arr.length; ++i) {
            idx[i][0] = arr[i];
            idx[i][1] = i;
        }

        Arrays.sort(idx, (a, b) -> Integer.compare(a[0], b[0]));

        int lo = 0;
        for (int hi = 1; hi <= arr.length; ++hi) {
            if (hi == arr.length || idx[hi - 1][0] + 1 != idx[hi][0]) {
                Arrays.sort(idx, lo, hi, (a, b) -> Integer.compare(a[1], b[1]));
                List<Integer> group = new ArrayList<>();
                for (; lo < hi; ++lo)
                    group.add(idx[lo][0]);
                groups.add(group);
            }
        }
        return groups;
    }

    public static void main(String[] args) {
        int[] A = {9, 11, 8, 2, 4, 7, 1, 0, 3, 6, -1, 10};
        System.out.println(foundGroups(A));
    }

}
