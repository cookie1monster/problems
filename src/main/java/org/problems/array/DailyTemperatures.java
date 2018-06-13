package org.problems.array;

import java.util.Arrays;

//https://leetcode.com/problems/daily-temperatures/description/
public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] index = new int[101];
        int[] result = new int[temperatures.length];
        int max = 0;
        for (int i = temperatures.length - 1; i >= 0; --i) {
            index[temperatures[i]] = i;
            max = Math.max(max, temperatures[i]);
            int closestHighIndex = Integer.MAX_VALUE;
            for (int j = temperatures[i] + 1; j <= max; ++j) {
                if (index[j] > 0 && index[j] < closestHighIndex) {
                    closestHighIndex = index[j];
                }
            }
            if (closestHighIndex != Integer.MAX_VALUE)
                result[i] = closestHighIndex - i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
