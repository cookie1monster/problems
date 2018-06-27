package org.problems.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/course-schedule-iii/description/
public class CourseSchedule3 {

    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (int[] x, int[] y) -> x[1] - y[1]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] x, int[] y) -> y[0] - x[0]);

        int currTime = 0;
        for (int[] cource : courses) {
            if (cource[0] > cource[1]) continue;
            if (currTime + cource[0] <= cource[1]) {
                queue.offer(cource);
                currTime += cource[0];
            } else if (currTime - queue.peek()[0] + cource[0] <= cource[1]) {
                queue.offer(cource);
                currTime = currTime - queue.poll()[0] + cource[0];
            }
        }
        return queue.size();
    }

    public static void main(String[] args) {
        System.out.println(scheduleCourse(new int[][]{{100, 2}, {32, 50}}) == 1);
        System.out.println(scheduleCourse(new int[][]{{5, 15}, {3, 19}, {6, 7}, {2, 10}, {5, 16}, {8, 14}, {10, 11}, {2, 19}}) == 5);
        System.out.println(scheduleCourse(new int[][]{{7, 17}, {3, 12}, {10, 20}, {9, 10}, {5, 20}, {10, 19}, {4, 18}}) == 4);
        System.out.println(scheduleCourse(new int[][]{{5, 5}, {4, 6}, {2, 6}}) == 2);
        System.out.println(scheduleCourse(new int[][]{{1, 2}, {2, 3}}) == 2);
        System.out.println(scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}) == 3);
    }
}
