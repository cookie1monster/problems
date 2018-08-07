package org.problems.structure;

import java.util.TreeMap;

//https://leetcode.com/problems/my-calendar-iii/description/
public class MyCalendar3 {

    public static void main(String[] args) {
        MyCalendarThree calendarThree = new MyCalendarThree();

        System.out.println(calendarThree.book(10, 20));
        System.out.println(calendarThree.book(10, 20));
        System.out.println(calendarThree.book(10, 20));

        System.out.println(calendarThree.book(10, 20)); // returns 1
        System.out.println(calendarThree.book(50, 60)); // returns 1
        System.out.println(calendarThree.book(10, 40)); // returns 2
        System.out.println(calendarThree.book(5, 15)); // returns 3
        System.out.println(calendarThree.book(5, 10)); // returns 3
        System.out.println(calendarThree.book(25, 55)); // returns 3


        int[][] in = {{24, 40}, {43, 50}, {27, 43}, {5, 21}, {30, 40}, {14, 29}, {3, 19}, {3, 14}, {25, 39}, {6, 19}};
        for (int i = 0; i < in.length; ++i)
            System.out.println(calendarThree.book(in[i][0], in[i][1]));
    }
}

class MyCalendarThree {

    private TreeMap<Integer, Integer> tree;
    private int maxOverlap = 0;

    public MyCalendarThree() {
        tree = new TreeMap<>();
    }

    public int book(int start, int end) {
        tree.put(start, tree.getOrDefault(start, 0) + 1);
        tree.put(end, tree.getOrDefault(end, 0) - 1);
        int curOverlap = 0;
        for (int val : tree.headMap(end).values()) {
            curOverlap += val;
            maxOverlap = Math.max(maxOverlap, curOverlap);
        }
        return maxOverlap;
    }
}