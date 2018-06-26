package org.problems.recursion;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/matchsticks-to-square/description/
public class MatchsticksSquare {

    private static boolean makesquare(int[][] data, int side, int curSide, int[] used, int leftSides) {
        if (leftSides == 0)
            return true;

        if (curSide == side)
            curSide = 0;

        for (int i = 0; i < data.length; ++i) {
            if (used[i] < data[i][1] && data[i][0] + curSide <= side) {
                used[i]++;
                if (makesquare(data, side, curSide + data[i][0], used, leftSides - 1))
                    return true;
                used[i]--;
            }
        }
        return false;
    }

    public static boolean makesquare(int[] nums) {
        if (nums.length == 0)
            return false;

        int sum = 0;
        for (int num : nums)
            sum += num;

        int side = sum / 4;
        if (sum % 4 != 0)
            return false;

        int sideQnt = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num > side)
                return false;
            else if (num < side)
                map.put(num, map.getOrDefault(num, 0) + 1);
            else
                sideQnt--;
        }

        int[][] data = new int[map.keySet().size()][2];
        int i = 0;
        for (int key : map.keySet()) {
            data[i][0] = key;
            data[i++][1] = map.get(key);
        }

        return makesquare(data, side, 0, new int[data.length], sideQnt);
    }

    public static void main(String[] args) {
        System.out.println(makesquare(new int[]{1, 1, 2, 2, 2}));
        System.out.println(makesquare(new int[]{5, 5, 5, 5, 16, 4, 4, 4, 4, 4, 3, 3, 3, 3, 4}));
        System.out.println(makesquare(new int[]{3, 3, 3, 3, 4}));
    }
}
