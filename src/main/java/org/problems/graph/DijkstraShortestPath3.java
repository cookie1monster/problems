package org.problems.graph;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.problems.utils.FastReader;

//https://www.hackerrank.com/challenges/dijkstrashortreach/problem
public class DijkstraShortestPath3 {

    private static class Point implements Comparable<Point> {
        int index;
        Point parent;
        int cost;

        @Override
        public int compareTo(Point obj) {
            return Integer.compare(this.cost, obj.cost);
        }

        public Point(int index, Point parent, int cost) {
            this.cost = cost;
            this.parent = parent;
            this.index = index;
        }
    }

    private static int[] shortestReach(int n, int[][] edges, int start) {

        Map<Integer, Map<Integer, Point>> g = new HashMap<>();
        Map<Integer, Point> distMap = new HashMap<>();
        PriorityQueue<Point> pq = new PriorityQueue<>();


        for (int i = 1; i <= n; ++i) {
            g.put(i, new HashMap<>());
            distMap.put(i, new Point(i, null, Integer.MAX_VALUE));
        }
        distMap.get(start).cost = 0;

        for (int[] edge : edges) {
            if (g.get(edge[0]).get(edge[1]) == null || g.get(edge[0]).get(edge[1]).cost > edge[2]) {
                g.get(edge[0]).put(edge[1], new Point(edge[1], null, edge[2]));
                g.get(edge[1]).put(edge[0], new Point(edge[0], null, edge[2]));
            }
        }

        pq.offer(distMap.get(start));

        while (!pq.isEmpty()) {
            Point p = pq.poll();
            for (Point adj : g.get(p.index).values()) {
                if (distMap.get(p.index).cost + adj.cost < distMap.get(adj.index).cost) {
                    distMap.get(adj.index).cost = distMap.get(p.index).cost + adj.cost;
                    distMap.get(adj.index).parent = p;
                    pq.offer(distMap.get(adj.index));
                }
            }
        }

        int j = 0;
        int[] ans = new int[n - 1];
        for (int i = 1; i <= n; ++i) {
            if (distMap.get(i).cost == Integer.MAX_VALUE)
                ans[j++] = -1;
            else if (i != start)
                ans[j++] = distMap.get(i).cost;
        }

        return ans;
    }

        /*
    1
    4 4
    1 2 24
    1 4 20
    3 1 3
    4 3 12
    1

    1
    4 5
    1 2 24
    1 4 20
    3 1 301
    4 3 12
    2 3 1
    1
        */

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        FastReader reader = new FastReader();
        int t = reader.nextInt();

        for (int tItr = 0; tItr < t; tItr++) {
            int n = reader.nextInt();
            int m = reader.nextInt();

            int[][] edges = new int[m][3];

            for (int edgesRowItr = 0; edgesRowItr < m; edgesRowItr++) {
                for (int edgesColumnItr = 0; edgesColumnItr < 3; edgesColumnItr++) {
                    edges[edgesRowItr][edgesColumnItr] = reader.nextInt();
                }
            }

            int s = reader.nextInt();

            int[] result = shortestReach(n, edges, s);

            System.out.println(Arrays.toString(result));
            /*for (int resultItr = 0; resultItr < result.length; resultItr++) {
                bufferedWriter.write(String.valueOf(result[resultItr]));

                if (resultItr != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();*/
        }

        //bufferedWriter.close();
    }
}
