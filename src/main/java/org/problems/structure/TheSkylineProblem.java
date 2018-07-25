package org.problems.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/the-skyline-problem/description/
public class TheSkylineProblem {

    public static List<int[]> getSkyline(int[][] buildings) {

        PriorityQueue<int[]> que = new PriorityQueue<>((x, y) -> {
            if (x[0] == y[0])
                return y[2] - x[2];
            return x[0] - y[0];
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            if (y[2] == x[2])
                return y[1] - x[1];
            return y[2] - x[2];
        });
        for (int[] build : buildings)
            que.offer(build);

        List<int[]> res = new ArrayList<>();
        res.add(new int[]{0, 0});
        que.offer(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 0});

        while (!que.isEmpty()) {
            int[] build = que.poll();

            if (!pq.isEmpty() && (pq.peek()[1] < build[0] || que.isEmpty())) {
                while (pq.size() > 1 && pq.peek()[1] < build[0]) {
                    pq.removeIf((x) -> x != pq.peek() && (x[1] <= pq.peek()[1] && x[2] <= pq.peek()[2]));
                    if (pq.size() > 1)
                        res.add(new int[]{pq.poll()[1], pq.peek()[2]});
                }
                if (pq.size() == 1 && (pq.peek()[1] < build[0] || que.isEmpty()))
                    res.add(new int[]{pq.poll()[1], 0});
            }

            pq.offer(build);

            if (build[2] > res.get(res.size() - 1)[1])
                res.add(new int[]{build[0], build[2]});
        }

        return res.subList(1, res.size());
    }


    public static void main(String[] args) {
        //[[2,4,70],[3,8,30],[6,100,41],[7,15,70],[10,30,102],[15,25,76],[60,80,91],[70,90,72],[85,120,59]]

        getSkyline(new int[][]{{1, 5, 3}, {1, 5, 3}, {1, 5, 3}})
                .forEach(x -> System.out.println(Arrays.toString(x)));
        System.out.println("-----");
        //[[0,2147483647,2147483647]]
        getSkyline(new int[][]{{0, 2147483647, 2147483647}})
                .forEach(x -> System.out.println(Arrays.toString(x)));
        System.out.println("-----");
        getSkyline(new int[][]{{1, 2, 1}, {1, 2, 2}, {1, 2, 3}})
                .forEach(x -> System.out.println(Arrays.toString(x)));
        System.out.println("-----");
        getSkyline(new int[][]{{0, 2, 3}, {2, 5, 3}})
                .forEach(x -> System.out.println(Arrays.toString(x)));
        System.out.println("-----");

        //[2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0]
        getSkyline(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}})
                .forEach(x -> System.out.println(Arrays.toString(x)));
        System.out.println("-----");

    }
}
