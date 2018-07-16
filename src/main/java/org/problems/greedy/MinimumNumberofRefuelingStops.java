package org.problems.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/contest/weekly-contest-93/problems/minimum-number-of-refueling-stops/
//https://leetcode.com/problems/minimum-number-of-refueling-stops/description/
public class MinimumNumberofRefuelingStops {

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (target <= startFuel)
            return 0;
        Arrays.sort(stations, (x, y) -> x[0] - y[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);

        int stops = 0;
        int i = 0;
        int cur = startFuel;
        while (cur < target) {
            while (i < stations.length && stations[i][0] <= cur)
                queue.offer(stations[i++][1]);
            if (queue.isEmpty())
                return -1;
            cur += queue.poll();
            ++stops;
        }
        return stops;
    }

    public static void main(String[] args) {
        System.out.println(minRefuelStops(80, 10, new int[][]{{10, 50}, {20, 100}, {30, 1}}) == 2);
        System.out.println(minRefuelStops(100, 25, new int[][]{{25, 25}, {50, 25}, {75, 25}}) == 3);
        System.out.println(minRefuelStops(100, 50, new int[][]{{50, 50}}) == 1);
        System.out.println(minRefuelStops(100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}) == 2);
        System.out.println(minRefuelStops(100, 1, new int[][]{{10, 100}}) == -1);
    }
}
