package org.problems.sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/ctci-find-the-running-median/problem
public class RunningMedian {

    public static double[] runningMedian(int[] a) {
        double[] medians = new double[a.length];
        Comparator<Integer> comp = Comparator.comparingInt(v -> v);
        PriorityQueue<Integer> left = new PriorityQueue<>(comp.reversed());
        PriorityQueue<Integer> right = new PriorityQueue<>(comp);
        for (int i = 0; i < a.length; ++i) {
            if (left.size() == 0 || left.peek() > a[i])
                left.offer(a[i]);
            else
                right.offer(a[i]);

            if (Math.abs(left.size() - right.size()) > 1) {
                if (left.size() <= right.size()) {
                    left.add(right.poll());
                } else {
                    right.add(left.poll());
                }
            }

            if (left.size() == right.size())
                medians[i] = (left.peek() + right.peek()) / 2.;
            else
                medians[i] = (left.size() > right.size()) ? left.peek() : right.peek();
        }
        return medians;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            int aItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            a[i] = aItem;
        }
        double[] medians = runningMedian(a);
        for (double median : medians)
            System.out.println(median);

        scanner.close();
    }

}
